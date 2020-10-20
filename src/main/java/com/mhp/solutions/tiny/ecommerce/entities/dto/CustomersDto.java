package com.mhp.solutions.tiny.ecommerce.entities.dto;

import com.mhp.solutions.tiny.ecommerce.entities.User;

import java.io.Serializable;
import java.util.Date;

public class CustomersDto implements Serializable {

    private static final long serialVersionUID = 6695584952625373452L;

    private Long id;

    private User user;

    private Date birthDate;

    private String address;

    private String postalCode;

    private String city;

    private String customerImage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCustomerImage() {
        return customerImage;
    }

    public void setCustomerImage(String customerImage) {
        this.customerImage = customerImage;
    }
}
