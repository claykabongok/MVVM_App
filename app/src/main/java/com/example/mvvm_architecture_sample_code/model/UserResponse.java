package com.example.mvvm_architecture_sample_code.model;

import java.util.List;

public class UserResponse {


    public List<User> userList;
    private Throwable error;
    private int status;
    private String message;

    public UserResponse(List<User> userList) {
        this.userList = userList;
        this.error = null;
        this.status = 0;
        this.message = null;
    }
    public UserResponse(Throwable error){
        this.userList = null;
        this.error = error;
        this.status = 0;
        this.message = null;
    }

    public UserResponse(int status,String message){
        this.userList = null;
        this.error = null;
        this.status = status;
        this.message = message;
    }


    public List<User> getUserList() {
        return userList;
    }

    public UserResponse setUserList(List<User> userList) {
        this.userList = userList;
        return this;
    }

    public Throwable getError() {
        return error;
    }

    public UserResponse setError(Throwable error) {
        this.error = error;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public UserResponse setStatus(int status) {
        this.status = status;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public UserResponse setMessage(String message) {
        this.message = message;
        return this;
    }
}
