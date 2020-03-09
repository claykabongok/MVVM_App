package com.example.mvvm_architecture_sample_code;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.example.mvvm_architecture_sample_code.adapter.UserAdapter;
import com.example.mvvm_architecture_sample_code.databinding.ActivityMainBinding;
import com.example.mvvm_architecture_sample_code.model.UserResponse;
import com.example.mvvm_architecture_sample_code.util.NetworkStatus;
import com.example.mvvm_architecture_sample_code.viewmodel.UserViewModel;

public class MainActivity extends AppCompatActivity {

    //private RecyclerView recyclerView;
    private UserAdapter adapter;
    //private ProgressBar progressBar;
    private UserViewModel userViewModel;
    private ActivityMainBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        View view= binding.getRoot();

        setContentView(view);
        userViewModel= ViewModelProviders.of(this).get(UserViewModel.class);
        binding.recyclerview.setHasFixedSize(true);
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(this));


        boolean isConnected= NetworkStatus.isDeviceConnected(this);
        if(isConnected){
            load_data();
        }else {
            binding.progressBar.setVisibility(View.GONE);
            Toast.makeText(this, "Device offline", Toast.LENGTH_LONG).show();
        }


    }
    private void showError(String message){
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();


    }
    private void load_data() {


        userViewModel.getListUsers().observe(this, new Observer<UserResponse>() {

            @Override
            public void onChanged(UserResponse userResponse) {

                binding.progressBar.setVisibility(View.GONE);
                if(userResponse.getError() != null){

                    binding.progressBar.setVisibility(View.GONE);

                    showError("There was an error while processing your request "+userResponse.getError().getMessage());

                }

                if(userResponse.getUserList().size() >= 1){
                    try {

                        adapter= new UserAdapter(userResponse.getUserList());

                        binding.recyclerview.setAdapter(adapter);
                    } catch (Exception e) {
                        e.printStackTrace();

                    }
                }



            }
        });
    }

}
