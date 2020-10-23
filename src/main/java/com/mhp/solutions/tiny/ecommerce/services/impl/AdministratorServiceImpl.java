package com.mhp.solutions.tiny.ecommerce.services.impl;

import com.mhp.solutions.tiny.ecommerce.config.ObjectMapperUtils;
import com.mhp.solutions.tiny.ecommerce.entities.Administrators;
import com.mhp.solutions.tiny.ecommerce.entities.dto.AdministatorsDto;
import com.mhp.solutions.tiny.ecommerce.repository.AdministratorsRepo;
import com.mhp.solutions.tiny.ecommerce.services.IAdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdministratorServiceImpl implements IAdministratorService {
    @Autowired
    AdministratorsRepo administratorsRepo;

    @Override
    public AdministatorsDto getAdministratorById(Long adminId) {
        Administrators entity = administratorsRepo.findAdministratorsById(adminId);
        AdministatorsDto administatorsDto = ObjectMapperUtils.map(entity,AdministatorsDto.class);
        return administatorsDto;
    }

    @Override
    @Transactional
    public void addAdministrator(AdministatorsDto administatorsDto) {
        final Administrators entity = ObjectMapperUtils.map(administatorsDto, Administrators.class);
        administratorsRepo.save(entity);
        administatorsDto.setId(entity.getId());
    }

    @Override
    @Transactional
    public void updateAdministrator(AdministatorsDto administatorsDto) {
        final Administrators entity = ObjectMapperUtils.map(administatorsDto, Administrators.class);
        administratorsRepo.save(entity);
        administatorsDto.setId(entity.getId());
    }

    @Override
    @Transactional
    public void deleteAdministratorById(Long adminId) {
        administratorsRepo.deleteById(adminId);
    }
}
