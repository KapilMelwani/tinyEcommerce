package com.mhp.solutions.tiny.ecommerce.api;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

public class ApiSuccess implements Serializable {

    private static final long serialVersionUID = 1581686941948826353L;

    private Long id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;

    public ApiSuccess(Long id, String message) {
        this.id = id;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
