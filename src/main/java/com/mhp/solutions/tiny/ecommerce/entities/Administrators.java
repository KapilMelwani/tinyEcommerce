package com.mhp.solutions.tiny.ecommerce.entities;

import com.mhp.solutions.tiny.ecommerce.entities.dto.ProductsDto;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ADMINISTRATORS")
public class Administrators {

    @Id
    private Long id;

    @OneToOne
    @MapsId
    @NotNull
    private User user;

    private String address;

    @Length(max = 5)
    private String postalCode;

    private String city;

    private String administratorImage;

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
