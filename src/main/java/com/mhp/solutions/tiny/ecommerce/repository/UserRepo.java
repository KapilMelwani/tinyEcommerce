package com.mhp.solutions.tiny.ecommerce.repository;

import com.mhp.solutions.tiny.ecommerce.entities.Products;
import com.mhp.solutions.tiny.ecommerce.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
    User findUserByEmail(String email);
    User findUserById(Long userId);
    void deleteUserById(Long userId);
}
