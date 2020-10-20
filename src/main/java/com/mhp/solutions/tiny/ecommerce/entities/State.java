package com.mhp.solutions.tiny.ecommerce.entities;

public enum State {
    ORDEDED(1),
    APROVED(2),
    SENDED(3),
    RECEIVED(4);

    private int code;

    State(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
