package com.mhp.solutions.tiny.ecommerce.repository;

import com.mhp.solutions.tiny.ecommerce.entities.Administrators;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministratorsRepo extends JpaRepository<Administrators,Long> {
    Administrators findAdministratorsById(Long adminId);
    void deleteAdministratorsById(Long adminId);
}
