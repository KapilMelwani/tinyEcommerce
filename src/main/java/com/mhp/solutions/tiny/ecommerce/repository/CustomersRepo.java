package com.mhp.solutions.tiny.ecommerce.repository;

import com.mhp.solutions.tiny.ecommerce.entities.Administrators;
import com.mhp.solutions.tiny.ecommerce.entities.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersRepo extends JpaRepository<Customers,Long> {
    Customers findCustomersByIdAndUserIsActive(Long customerId,Boolean isActive);
    void deleteCustomersById(Long customerId);
}
