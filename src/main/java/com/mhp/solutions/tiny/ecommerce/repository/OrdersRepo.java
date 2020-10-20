package com.mhp.solutions.tiny.ecommerce.repository;

import com.mhp.solutions.tiny.ecommerce.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersRepo extends JpaRepository<Orders,Long> {
}
