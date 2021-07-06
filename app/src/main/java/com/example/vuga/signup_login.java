package com.example.vuga;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.vuga.Models.Users;
import com.example.vuga.databinding.ActivitySignupLoginBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class signup_login extends AppCompatActivity {
    ActivitySignupLoginBinding binding;
    private FirebaseAuth Auth;
    FirebaseDatabase dataBase;
    ProgressDialog progressDialog;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Auth = FirebaseAuth.getInstance();
        dataBase = FirebaseDatabase.getInstance();
        progressDialog= new ProgressDialog(signup_login.this);
        progressDialog.setTitle("Creating account ");
        progressDialog.setMessage("We're creating your account");
        binding.btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();
                Auth.createUserWithEmailAndPassword(binding.etEmail.getText().toString(), binding.etPass.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if(task.isSuccessful()){

                            Users user = new Users(binding.etUsername.getText().toString(),binding.etEmail.getText().toString(),binding.etPass.getText().toString());
                            String id = task.getResult().getUser().getUid();
                            dataBase.getReference().child("Users").child(id).setValue(user);




                            Toast.makeText(signup_login.this, "Account created yay", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(signup_login.this,task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }


                    }
                });

            }
        });

        binding.already.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signup_login.this,Signin.class);
                startActivity(intent);

            }
        });

        getSupportActionBar().hide();
    }

}