package com.scatum.springboot.websocket.app.model;

public class UserResponse {

    String content;

    public UserResponse() {

    }

    public UserResponse(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
