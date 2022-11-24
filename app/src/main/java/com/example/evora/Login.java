package com.example.evora;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    EditText memail,mpassword;
    Button mLoginbtn;
    TextView mcreatebtn;
    FirebaseAuth fAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        memail=findViewById(R.id.email);
        mpassword=findViewById(R.id.password);
        mLoginbtn=findViewById(R.id.loginbtn);
        mcreatebtn=findViewById(R.id.sgtext);

        fAuth=FirebaseAuth.getInstance();


        mcreatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Register.class));
            }
        });
        mLoginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String email=memail.getText().toString().trim();
                    String password=mpassword.getText().toString().trim();


                    if(TextUtils.isEmpty(email)){
                        memail.setError("Email cannot be empty");
                        return;
                    }
                    if(TextUtils.isEmpty(password)){
                        mpassword.setError("Password cannot be empty");
                        return;
                    }

                    fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(getApplicationContext(), "Login successfull", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(),car_rto.class));

                            }
                            else{
                                Toast.makeText(getApplicationContext(), "Some error occured"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
            }
        });

    }



}