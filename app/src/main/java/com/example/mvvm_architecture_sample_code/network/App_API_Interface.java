package com.example.mvvm_architecture_sample_code.network;

import com.example.mvvm_architecture_sample_code.model.User;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface App_API_Interface {

    /**
     * list of users
     * git config --global user.name@return
     */
    @GET("users")
    Call<List<User>> getUsers();




}
