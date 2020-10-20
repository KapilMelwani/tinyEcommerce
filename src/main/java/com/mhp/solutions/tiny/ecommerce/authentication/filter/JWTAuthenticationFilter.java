package com.mhp.solutions.tiny.ecommerce.authentication.filter;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mhp.solutions.tiny.ecommerce.authentication.UserDetails;
import com.mhp.solutions.tiny.ecommerce.authentication.service.JWTService;
import com.mhp.solutions.tiny.ecommerce.authentication.service.JWTServiceImpl;
import com.mhp.solutions.tiny.ecommerce.entities.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

  private final AuthenticationManager authenticationManager;
  private final JWTService jwtService;

  public JWTAuthenticationFilter(
          final AuthenticationManager authenticationManager, final JWTService jwtService) {
    this.authenticationManager = authenticationManager;
      setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/login", "POST"));
    this.jwtService = jwtService;
  }

  @Override
  public Authentication attemptAuthentication(
          final HttpServletRequest request, final HttpServletResponse response) throws AuthenticationException {

    String usermail = obtainUsername(request);
    String password = obtainPassword(request);

    if (usermail.isEmpty() && password.isEmpty()) {
      User user = null;
      try {
        user =
            new ObjectMapper()
                .readValue(
                    request.getInputStream(),
                   User.class);
        usermail = user.getEmail();
        password = user.getPassword();
      } catch (final JsonParseException e) {
        e.printStackTrace();
      } catch (final JsonMappingException e) {
        e.printStackTrace();
      } catch (final IOException e) {
        e.printStackTrace();
      }
    }
    usermail.trim();
    final UsernamePasswordAuthenticationToken authToken =
        new UsernamePasswordAuthenticationToken(usermail, password);
    return authenticationManager.authenticate(authToken);
  }

  @Override
  protected void successfulAuthentication(
          final HttpServletRequest request,
          final HttpServletResponse response,
          final FilterChain chain,
          final Authentication authResult)
      throws IOException, ServletException {

    final String token = jwtService.create(authResult);
    response.addHeader(JWTServiceImpl.HEADER_STRING, JWTServiceImpl.TOKEN_PREFIX + token);
    final Map<String, Object> body = new HashMap<String, Object>();
    body.put("token", "Bearer " + token);
    body.put("user", ((UserDetails) authResult.getPrincipal()).getUser());
    response.getWriter().write(new ObjectMapper().writeValueAsString(body));
    response.setStatus(200);
    response.setContentType(JWTServiceImpl.CONTENT_TYPE);
  }

  @Override
  protected void unsuccessfulAuthentication(
          final HttpServletRequest request, final HttpServletResponse response, final AuthenticationException failed)
      throws IOException, ServletException {
    final Map<String, Object> body = new HashMap<String, Object>();
    body.put("mensaje", "Error de autenticación: usermail o password incorrecto");
    body.put("error", failed.getMessage());

    response.getWriter().write(new ObjectMapper().writeValueAsString(body));
    response.setStatus(401);
    response.setContentType(JWTServiceImpl.CONTENT_TYPE);
  }
}
