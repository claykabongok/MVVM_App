package com.example.mvvm_architecture_sample_code.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    /**
     * Singleton class for Retrofit
     */
    String SERVICE_BASE_URL="https://jsonplaceholder.typicode.com/";
    private static RetrofitClient mInstance;
    private Retrofit retrofit;

    private  RetrofitClient(){

        retrofit = new Retrofit.Builder()
                .baseUrl(SERVICE_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public static synchronized RetrofitClient getInstance(){
        if(mInstance==null){ //retrofit instance not yet created
            mInstance = new RetrofitClient();
        }

        return mInstance;

    }

    public App_API_Interface get_Ers_API(){
        return retrofit.create(App_API_Interface.class);
    }

}
