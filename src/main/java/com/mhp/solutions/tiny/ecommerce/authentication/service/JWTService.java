package com.mhp.solutions.tiny.ecommerce.authentication.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.jsonwebtoken.Claims;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

public interface JWTService {

    String create(Authentication auth) throws JsonProcessingException;
    Boolean validate(String token);
    Claims getClaims(String token);
    String getUsermail(String token);
    Map<String,Object> getUserInfo(String token) throws IOException;
    Collection<? extends GrantedAuthority> getRoles(String token) throws IOException;
    String resolve(String token);
}
