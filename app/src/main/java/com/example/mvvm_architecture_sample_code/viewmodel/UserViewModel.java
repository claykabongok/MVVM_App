package com.example.mvvm_architecture_sample_code.viewmodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;

import com.example.mvvm_architecture_sample_code.model.UserResponse;
import com.example.mvvm_architecture_sample_code.repository.UserRepository;

public class UserViewModel extends AndroidViewModel {

    private MediatorLiveData<UserResponse> userResponseMediatorLiveData;
    private UserRepository userRepository;
    public UserViewModel(@NonNull Application application) {
        super(application);
        userResponseMediatorLiveData= new MediatorLiveData<>();
        userRepository= new UserRepository();
    }

    public LiveData<UserResponse> getListUsers(){
        userResponseMediatorLiveData.addSource(userRepository.getUsers(), new Observer<UserResponse>() {
            @Override
            public void onChanged(UserResponse userResponse) {
                userResponseMediatorLiveData.setValue(userResponse);
            }
        });
        return userResponseMediatorLiveData;
    }
}
