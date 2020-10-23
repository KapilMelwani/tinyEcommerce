package com.mhp.solutions.tiny.ecommerce.services;

import com.mhp.solutions.tiny.ecommerce.entities.dto.AdministatorsDto;

public interface IAdministratorService {
    AdministatorsDto getAdministratorById(Long adminId);
    void addAdministrator(AdministatorsDto administatorsDto);
    void updateAdministrator(AdministatorsDto administatorsDto);
    void deleteAdministratorById(Long adminId);
}
