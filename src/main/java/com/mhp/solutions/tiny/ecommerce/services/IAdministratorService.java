package com.mhp.solutions.tiny.ecommerce.services;

import com.mhp.solutions.tiny.ecommerce.entities.dto.AdministratorsDto;

public interface IAdministratorService {
    AdministratorsDto getAdministratorById(Long adminId);
    void addAdministrator(AdministratorsDto administatorsDto);
    void updateAdministrator(AdministratorsDto administatorsDto);
    void deleteAdministratorById(Long adminId);
}
