package com.mhp.solutions.tiny.ecommerce.services.impl;

import com.mhp.solutions.tiny.ecommerce.config.ObjectMapperUtils;
import com.mhp.solutions.tiny.ecommerce.entities.Customers;
import com.mhp.solutions.tiny.ecommerce.entities.dto.CustomersDto;
import com.mhp.solutions.tiny.ecommerce.repository.CustomersRepo;
import com.mhp.solutions.tiny.ecommerce.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    CustomersRepo customersRepo;

    @Override
    public CustomersDto getAdministratorByIdAndActive(Long customerId, Boolean isActive) {
        Customers entity = customersRepo.findCustomersByIdAndUserIsActive(customerId,isActive);
        CustomersDto administatorsDto = ObjectMapperUtils.map(entity,CustomersDto.class);
        return administatorsDto;
    }

    @Override
    @Transactional
    public void addCustomer(CustomersDto customersDto) {
        final Customers entity = ObjectMapperUtils.map(customersDto, Customers.class);
        customersRepo.save(entity);
        customersDto.setId(entity.getId());
    }

    @Override
    @Transactional
    public void updateCustomer(CustomersDto customersDto) {
        final Customers entity = ObjectMapperUtils.map(customersDto, Customers.class);
        customersRepo.save(entity);
        customersDto.setId(entity.getId());
    }

    @Override
    @Transactional
    public void deleteCustomerById(Long customerId) {
        customersRepo.deleteCustomersById(customerId);
    }
}
