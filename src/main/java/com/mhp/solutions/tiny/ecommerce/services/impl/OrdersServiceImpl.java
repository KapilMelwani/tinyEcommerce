package com.mhp.solutions.tiny.ecommerce.services.impl;

import com.mhp.solutions.tiny.ecommerce.config.ObjectMapperUtils;
import com.mhp.solutions.tiny.ecommerce.entities.Orders;
import com.mhp.solutions.tiny.ecommerce.entities.State;
import com.mhp.solutions.tiny.ecommerce.entities.dto.OrdersDto;
import com.mhp.solutions.tiny.ecommerce.repository.OrdersRepo;
import com.mhp.solutions.tiny.ecommerce.services.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrdersServiceImpl implements IOrdersService {
    @Autowired
    OrdersRepo ordersRepo;
    @Override
    public List<OrdersDto> getOrdersByActualStatus(State state) {
        final List<Orders> entities = ordersRepo.findOrdersByActualStatus(state);
        final List<OrdersDto> ordersDtoList = ObjectMapperUtils.mapAll(entities, OrdersDto.class);
        return ordersDtoList;
    }

    @Override
    public List<OrdersDto> getOrdersByCustomersId(Long customerId) {
        final List<Orders> entities = ordersRepo.findOrdersByCustomersId(customerId);
        final List<OrdersDto> ordersDtoList = ObjectMapperUtils.mapAll(entities, OrdersDto.class);
        return ordersDtoList;
    }

    @Override
    public List<OrdersDto> getOrdersByAdministratorsId(Long administratorId) {
        final List<Orders> entities = ordersRepo.findOrdersByAdministratorsId(administratorId);
        final List<OrdersDto> ordersDtoList = ObjectMapperUtils.mapAll(entities, OrdersDto.class);
        return ordersDtoList;
    }

    @Override
    public List<OrdersDto> getOrdersByProductsId(Long productId) {
        final List<Orders> entities = ordersRepo.findOrdersByProductsId(productId);
        final List<OrdersDto> ordersDtoList = ObjectMapperUtils.mapAll(entities, OrdersDto.class);
        return ordersDtoList;
    }

    @Override
    @Transactional
    public void addOrder(OrdersDto ordersDto) {
        final Orders entity = ObjectMapperUtils.map(ordersDto, Orders.class);
        ordersRepo.save(entity);
        ordersDto.setId(entity.getId());
    }

    @Override
    @Transactional
    public void updateOrder(OrdersDto ordersDto) {
        final Orders entity = ObjectMapperUtils.map(ordersDto, Orders.class);
        ordersRepo.save(entity);
        ordersDto.setId(entity.getId());
    }

    @Override
    @Transactional
    public void deleteOrderById(Long orderId) {
        ordersRepo.deleteOrdersById(orderId);
    }
}
