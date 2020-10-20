package com.mhp.solutions.tiny.ecommerce.authentication.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mhp.solutions.tiny.ecommerce.authentication.SimpleGrantedAuthorityMixin;
import com.mhp.solutions.tiny.ecommerce.authentication.UserDetails;
import com.mhp.solutions.tiny.ecommerce.entities.Roles;
import com.mhp.solutions.tiny.ecommerce.entities.dto.UserDto;
import com.mhp.solutions.tiny.ecommerce.services.impl.UserServiceImpl;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.util.*;

@Component
public class JWTServiceImpl implements JWTService {

  @Autowired
  UserServiceImpl userService;

  public static final String KEY =
      Base64Utils.encodeToString("hairpointSecretKeyKapilAshokMelwaniChugani".getBytes());
  public static final SecretKey SECRET_KEY =
      new SecretKeySpec(KEY.getBytes(), SignatureAlgorithm.HS256.getJcaName());

  public static final long EXPIRATION_DATE = 14000000L;
  public static final String TOKEN_PREFIX = "Bearer ";
  public static final String HEADER_STRING = "Authorization";
  public static final String CONTENT_TYPE = "application/json";
  public static final String AUTHORITIES = "authorities";
  public static final String USER_ID = "userId";
  public static final String COMPANY_ID = "companyId";

  @Override
  public String create(final Authentication authResult) throws JsonProcessingException {
    final String usermail = ((UserDetails) authResult.getPrincipal()).getUsername();
    final UserDto user = ((UserDetails) authResult.getPrincipal()).getUser();
    final Collection<? extends GrantedAuthority> roles = authResult.getAuthorities();
    final Claims claims = Jwts.claims();
    claims.put(AUTHORITIES, new ObjectMapper().writeValueAsString(roles));
    claims.put(USER_ID, user.getId().toString());
    final String token =
        Jwts.builder()
            .setClaims(claims)
            .setSubject(usermail)
            .signWith(SECRET_KEY)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_DATE))
            .compact();
    return token;
  }

  @Override
  public Boolean validate(final String token) {
    try {
      getClaims(token);
      return true;
    } catch (JwtException | IllegalArgumentException e) {
      return false;
    }
  }

  @Override
  public Claims getClaims(final String token) {
    final Claims claims =
        Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(resolve(token)).getBody();
    return claims;
  }

  @Override
  public String getUsermail(final String token) {
    return getClaims(token).getSubject();
  }

  @Override
  public Map<String, Object> getUserInfo(final String token) throws IOException {
    final Map<String, Object> userInfo = new HashMap<>();
    userInfo.put(USER_ID, Long.valueOf((String) getClaims(token).get(USER_ID)));
    final Collection<? extends GrantedAuthority> authorities = getRoles(token);
    return userInfo;
  }

  @Override
  public Collection<? extends GrantedAuthority> getRoles(final String token) throws IOException {
    final Object roles = getClaims(token).get(AUTHORITIES);
    final Collection<? extends GrantedAuthority> authorities =
        Arrays.asList(
            new ObjectMapper()
                .addMixIn(SimpleGrantedAuthority.class, SimpleGrantedAuthorityMixin.class)
                .readValue(roles.toString().getBytes(), SimpleGrantedAuthority[].class));
    return authorities;
  }

  @Override
  public String resolve(final String token) {
    if (token != null && token.startsWith(TOKEN_PREFIX)) {
      return token.replace(TOKEN_PREFIX, "");
    }
    return null;
  }
}
