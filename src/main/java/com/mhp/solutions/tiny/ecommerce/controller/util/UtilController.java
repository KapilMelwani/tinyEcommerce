package com.mhp.solutions.tiny.ecommerce.controller.util;

import com.mhp.solutions.tiny.ecommerce.api.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

import java.util.List;
import java.util.Map;

public class UtilController {

  protected Long getUserIdFromAuthenticationInfo(final Authentication authentication) {
    final Map<String, Long> userInfo = (Map<String, Long>) authentication.getCredentials();
    return userInfo.get("userId");
  }

  protected Boolean checkIfNotEmpty(final List<?> list) {
    return list != null && !list.isEmpty() ? true : false;
  }

  protected ResponseEntity<?> invalidParam(final String paramName) {
    return new ResponseEntity<>(
        new ApiError("[REQUIRED_PARAM]", "Invalid request. Check required param " + paramName),
        HttpStatus.BAD_REQUEST);
  }
}
