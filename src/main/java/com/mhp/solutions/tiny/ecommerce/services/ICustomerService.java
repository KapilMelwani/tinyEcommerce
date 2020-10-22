package com.mhp.solutions.tiny.ecommerce.services;

import com.mhp.solutions.tiny.ecommerce.entities.dto.CustomersDto;

import java.util.List;

public interface ICustomerService {
    CustomersDto getAdministratorByIdAndActive(Long customerId, Boolean isActive);
    void addCustomer(CustomersDto customersDto);
    void updateCustomer(CustomersDto customersDto);
    void deleteCustomerById(Long customerId);
}
