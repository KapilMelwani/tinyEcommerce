package com.mhp.solutions.tiny.ecommerce.entities;

public enum Gender {
    MALE(1), FEMALE(2);

    private int code;

    Gender(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}