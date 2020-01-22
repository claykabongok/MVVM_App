package com.example.mvvm_architecture_sample_code.repository;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.mvvm_architecture_sample_code.model.User;
import com.example.mvvm_architecture_sample_code.model.UserResponse;
import com.example.mvvm_architecture_sample_code.network.RetrofitClient;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {

    public LiveData<UserResponse> getUsers(){
        final MutableLiveData<UserResponse> userResponseMutableLiveData = new MutableLiveData<>();
        Call<List<User>> call =RetrofitClient.getInstance().get_Ers_API().getUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {

                if(response.isSuccessful()){

                    userResponseMutableLiveData.postValue(new UserResponse(response.body()));
                }
                else if(response.code()== 404){
                    userResponseMutableLiveData.postValue(new UserResponse(response.code(), "Results not found"));

                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
              userResponseMutableLiveData.postValue(new UserResponse(t));


            }
        });

     return userResponseMutableLiveData;
    }



}
