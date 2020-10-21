package com.mhp.solutions.tiny.ecommerce.services.impl;

import com.mhp.solutions.tiny.ecommerce.authentication.UserDetails;
import com.mhp.solutions.tiny.ecommerce.entities.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UserServiceImpl userService;
  private final Logger logger = LoggerFactory.getLogger(CustomUserDetailsServiceImpl.class);


  @Autowired
  public CustomUserDetailsServiceImpl(UserServiceImpl userService) {
    this.userService = userService;
  }

  @Override
  @Transactional(readOnly = true)
  public UserDetails loadUserByUsername(final String useremail) {
    try {
      UserDto user = userService.getUserByEmail(useremail);
      return new UserDetails(user);
    } catch (UsernameNotFoundException e) {
      throw new UsernameNotFoundException(String.format("User with email=%s was not found", useremail));
    }
  }
}
