package com.mhp.solutions.tiny.ecommerce.entities.dto;

import java.io.Serializable;
import java.util.Date;

public class ProductsDto implements Serializable {

    private static final long serialVersionUID = -8045007193528598325L;

    private Long id;

    private String productName;

    private String productDescription;

    private Double price;

    private CategoryDto productCategory;

    private AdministratorsDto productOwner;

    private Integer stock;

    private Date creationDate;

    private String productImage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public CategoryDto getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(CategoryDto productCategory) {
        this.productCategory = productCategory;
    }

    public AdministratorsDto getProductOwner() {
        return productOwner;
    }

    public void setProductOwner(AdministratorsDto productOwner) {
        this.productOwner = productOwner;
    }
}
