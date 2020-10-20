package com.mhp.solutions.tiny.ecommerce.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ORDERS")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Administrators administrators;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Customers customers;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<Products> products;

    private Date buyDate;

    private State actualStatus;

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

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

    public State getActualStatus() {
        return actualStatus;
    }

    public void setActualStatus(State actualStatus) {
        this.actualStatus = actualStatus;
    }
}


