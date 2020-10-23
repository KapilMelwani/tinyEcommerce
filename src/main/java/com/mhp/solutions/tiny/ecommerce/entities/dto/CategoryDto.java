package com.mhp.solutions.tiny.ecommerce.entities.dto;

import java.io.Serializable;

public class CategoryDto implements Serializable {

    private static final long serialVersionUID = 8401377639637578833L;

    private Long id;

    private String categoryName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
