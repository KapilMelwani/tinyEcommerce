package com.mhp.solutions.tiny.ecommerce.services;

import com.mhp.solutions.tiny.ecommerce.entities.dto.UserDto;

public interface IUserService {
    void addUser(UserDto userDto);
    void updateUser(UserDto userDto);
    void deleteUserById(Long userId);
    UserDto getUserByEmail(String email);
}
