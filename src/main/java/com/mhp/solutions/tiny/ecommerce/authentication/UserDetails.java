package com.mhp.solutions.tiny.ecommerce.authentication;

import com.mhp.solutions.tiny.ecommerce.entities.dto.UserDto;
import org.springframework.security.core.authority.AuthorityUtils;

public class UserDetails extends org.springframework.security.core.userdetails.User {

    private UserDto user;

    public UserDetails(UserDto user) {
        super(user.getEmail(),user.getPassword(), AuthorityUtils.createAuthorityList(user.getRol().toString()));
        this.user = user;
    }

    public UserDto getUser() {
        return user;
    }
}
