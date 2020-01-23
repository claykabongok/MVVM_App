package com.example.mvvm_architecture_sample_code.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

}
