package com.mhp.solutions.tiny.ecommerce.repository;

import com.mhp.solutions.tiny.ecommerce.entities.Orders;
import com.mhp.solutions.tiny.ecommerce.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface OrdersRepo extends JpaRepository<Orders,Long> {
    List<Orders> findOrdersByActualStatus(State state);
    List<Orders> findOrdersByCustomersId(Long customerId);
    List<Orders> findOrdersByAdministratorsId(Long administratorId);
    List<Orders> findOrdersByProductsId(Long productId);
    List<Orders> findOrdersByProductName(String productName);
}
