package com.mhp.solutions.tiny.ecommerce.entities.dto;

import com.mhp.solutions.tiny.ecommerce.entities.Administrators;
import com.mhp.solutions.tiny.ecommerce.entities.Customers;
import com.mhp.solutions.tiny.ecommerce.entities.Products;

import java.io.Serializable;
import java.util.List;

public class OrdersDto implements Serializable {

    private static final long serialVersionUID = -5866731421467094677L;

    private Long id;

    private Administrators administrators;

    private Customers customers;

    private List<Products> products;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Administrators getAdministrators() {
        return administrators;
    }

    public void setAdministrators(Administrators administrators) {
        this.administrators = administrators;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }
}
