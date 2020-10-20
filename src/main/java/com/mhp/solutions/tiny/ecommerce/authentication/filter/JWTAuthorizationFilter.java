package com.mhp.solutions.tiny.ecommerce.authentication.filter;

import com.mhp.solutions.tiny.ecommerce.authentication.service.JWTService;
import com.mhp.solutions.tiny.ecommerce.authentication.service.JWTServiceImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    private JWTService jwtService;

    public JWTAuthorizationFilter(AuthenticationManager authenticationManager, JWTService jwtService) {
        super(authenticationManager);
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader(JWTServiceImpl.HEADER_STRING);

        if(requiresAuthentication(header) == false) {
            chain.doFilter(request,response);
            return;
        }
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = null;
        if(jwtService.validate(header)) {
            usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(jwtService.getUsermail(header), jwtService.getUserInfo(header), jwtService.getRoles(header));
        }
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        chain.doFilter(request,response);
    }

    protected boolean requiresAuthentication(String header) {
        return (header == null || !header.startsWith(JWTServiceImpl.TOKEN_PREFIX)) ? false : true;
    }
}
