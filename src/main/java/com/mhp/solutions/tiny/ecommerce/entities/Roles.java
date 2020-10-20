package com.mhp.solutions.tiny.ecommerce.entities;

public enum Roles {
    CUSTOMER(1),
    ADMINISTRATOR(2);

    private int code;

    Roles(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
