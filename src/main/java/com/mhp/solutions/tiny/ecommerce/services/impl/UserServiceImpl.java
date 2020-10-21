package com.mhp.solutions.tiny.ecommerce.services.impl;

import com.mhp.solutions.tiny.ecommerce.config.ObjectMapperUtils;
import com.mhp.solutions.tiny.ecommerce.entities.User;
import com.mhp.solutions.tiny.ecommerce.entities.dto.UserDto;
import com.mhp.solutions.tiny.ecommerce.repository.UserRepo;
import com.mhp.solutions.tiny.ecommerce.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    UserRepo userRepo;

    @Override
    @Transactional
    public void addUser(UserDto userDto) {
        final User entity = ObjectMapperUtils.map(userDto, User.class);
        userRepo.save(entity);
        userDto.setId(entity.getId());
    }

    @Override
    @Transactional
    public void updateUser(UserDto userDto) {
        final User entity = ObjectMapperUtils.map(userDto, User.class);
        userRepo.save(entity);
        userDto.setId(entity.getId());
    }

    @Override
    @Transactional
    public void deleteUserById(Long userId) {
        userRepo.deleteUserById(userId);
    }

    @Override
    public UserDto getUserByEmail(String email) {
        User entity = userRepo.findUserByEmail(email);
        UserDto userDto = ObjectMapperUtils.map(entity,UserDto.class);
        return userDto;
    }
}
