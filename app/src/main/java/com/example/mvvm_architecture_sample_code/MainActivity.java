package com.example.mvvm_architecture_sample_code;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.example.mvvm_architecture_sample_code.adapter.UserAdapter;
import com.example.mvvm_architecture_sample_code.model.UserResponse;
import com.example.mvvm_architecture_sample_code.viewmodel.UserViewModel;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private UserAdapter adapter;
    private ProgressBar progressBar;
    private UserViewModel userViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userViewModel= ViewModelProviders.of(this).get(UserViewModel.class);

        recyclerView= findViewById(R.id.recyclerview);
        progressBar=findViewById(R.id.progressBar);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        
        load_data();

    }
    private void showError(String message){
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();

    }
    private void load_data() {


        userViewModel.getListUsers().observe(this, new Observer<UserResponse>() {

            @Override
            public void onChanged(UserResponse userResponse) {
                progressBar.setVisibility(View.GONE);
                if(userResponse.getError() != null){

                    progressBar.setVisibility(View.GONE);

                    showError("There was an error while processing your request "+userResponse.getError().getMessage());

                }
                if(userResponse == null){
                    progressBar.setVisibility(View.GONE);
                    showError("Unable to retieve data, Please try again.");
                }
                if(userResponse.getError() == null && userResponse.getStatus() != 404){
                    try {

                        adapter= new UserAdapter(userResponse.getUserList());
                        recyclerView.setAdapter(adapter);
                    } catch (Exception e) {
                        e.printStackTrace();

                    }
                }



            }
        });
    }

}
