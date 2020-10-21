package com.mhp.solutions.tiny.ecommerce.entities.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mhp.solutions.tiny.ecommerce.entities.Gender;
import com.mhp.solutions.tiny.ecommerce.entities.Roles;

import java.io.Serializable;


public class UserDto implements Serializable {

    private static final long serialVersionUID = -5089486329415918381L;

    private Long id;

    private String name;

    private String surname;

    private String email;

    private Gender gender;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private String phoneNumber;

    private Boolean isActive = true;

    private Roles rol;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Roles getRol() {
        return rol;
    }

    public void setRol(Roles rol) {
        this.rol = rol;
    }
}
