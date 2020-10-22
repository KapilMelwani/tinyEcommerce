package com.mhp.solutions.tiny.ecommerce.services;

import com.mhp.solutions.tiny.ecommerce.entities.State;
import com.mhp.solutions.tiny.ecommerce.entities.dto.OrdersDto;

import java.util.List;

public interface IOrdersService {
    List<OrdersDto> getOrdersByActualStatus(State state);
    List<OrdersDto> getOrdersByCustomersId(Long customerId);
    List<OrdersDto> getOrdersByAdministratorsId(Long administratorId);
    List<OrdersDto> getOrdersByProductsId(Long productId);
    void addOrder(OrdersDto ordersDto);
    void updateOrder(OrdersDto ordersDto);
    void deleteOrderById(Long orderId);
}
