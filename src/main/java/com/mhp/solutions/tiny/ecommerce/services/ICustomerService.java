package com.mhp.solutions.tiny.ecommerce.services;

import com.mhp.solutions.tiny.ecommerce.entities.dto.CustomersDto;

import java.util.List;

public interface ICustomerService {
    CustomersDto getAdministratorById(Long customerId);
    void addCustomer(CustomersDto customersDto);
    void updateCustomer(CustomersDto customersDto);
    void deleteCustomerById(Long customerId);
}
