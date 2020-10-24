package com.mhp.solutions.tiny.ecommerce.entities;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "PRODUCTS")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false)
    private Long id;

    @Column(name = "PRODUCT_NAME", unique = true)
    @NotNull
    private String productName;

    @Column(name = "PRODUCT_DESCRIPTION")
    private String productDescription;

    @Column(name = "PRICE")
    @NotNull
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category productCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    private Administrators productOwner;

    @Column(name = "STOCK")
    @NotNull
    private Integer stock;

    @Column(name = "CREATION_DATE")
    private Date creationDate;

    @Column(name = "PRODUCT_IMG_URL")
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

    public Category getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(Category productCategory) {
        this.productCategory = productCategory;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Administrators getProductOwner() {
        return productOwner;
    }

    public void setProductOwner(Administrators productOwner) {
        this.productOwner = productOwner;
    }
}
