package com.mhp.solutions.tiny.ecommerce.entities.dto;

import java.io.Serializable;
import java.util.Date;

public class AdministratorsDto implements Serializable {

    private static final long serialVersionUID = -3639032996487061986L;

    private Long id;

    private UserDto user;

    private Date birthDate;

    private String address;

    private String postalCode;

    private String city;

    private String administratorImage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
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

    public String getAdministratorImage() {
        return administratorImage;
    }

    public void setAdministratorImage(String administratorImage) {
        this.administratorImage = administratorImage;
    }
}
