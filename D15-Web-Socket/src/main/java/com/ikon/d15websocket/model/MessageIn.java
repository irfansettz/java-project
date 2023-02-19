package com.ikon.d15websocket.model;


public class MessageIn {
    private String message;

    public MessageIn() {
    }

    public MessageIn(String name) {
        this.message = name;
    }

    public String getMessage() {
        return message;
    }
}
