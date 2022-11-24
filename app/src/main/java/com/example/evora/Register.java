package com.example.evora;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import kotlin.text.UStringsKt;

public class Register extends AppCompatActivity {
    public static final String TAG="TAG";
    EditText mfullname,memail,mpassword;
    TextView mctext;
    Button mregbtn;
    ProgressBar progbar;

    FirebaseFirestore fstore;
    String userID;
    String email = "";
    String pass = "";
    FirebaseAuth fAuth;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mfullname = findViewById(R.id.fullname);
        memail = findViewById(R.id.email);
        mpassword = findViewById(R.id.password);
        mregbtn = findViewById(R.id.regbtn);
        progbar = findViewById(R.id.progbar);
        mctext= findViewById(R.id.ctext);

        fAuth=FirebaseAuth.getInstance();
        fstore=FirebaseFirestore.getInstance();

        if(fAuth.getCurrentUser()!=null){
            startActivity(new Intent(getApplicationContext(),Login.class));
            finish();
        }



    mctext.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(getApplicationContext(),Login.class));
        }
    });

     mregbtn.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             String email = memail.getText().toString().trim();
            pass = mpassword.getText().toString().trim();

             final String fname = mfullname.getText().toString().trim();
             fAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                 @Override
                 public void onComplete(@NonNull Task<AuthResult> task) {
                     if(task.isSuccessful()){
                         FirebaseUser fuser=fAuth.getCurrentUser();
                         fuser.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                             @Override
                             public void onSuccess(Void unused) {
                                 Toast.makeText(getApplicationContext(),"Register successful",Toast.LENGTH_SHORT).show();
                             }
                         }).addOnFailureListener(new OnFailureListener() {
                             @Override
                             public void onFailure(@NonNull Exception e) {
                                 Log.d(TAG,"OnFailure: Message not Sent");
                             }
                         });

                         Toast.makeText(getApplicationContext(),"User Created",Toast.LENGTH_SHORT).show();
                         userID=fAuth.getCurrentUser().getUid();
                         DocumentReference documentReference= fstore.collection("user").document(userID);
                         Map<String,Object> user=new HashMap<>();
                         user.put("fname",mfullname);
                         user.put("email",memail);
                         documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                             @Override
                             public void onSuccess(Void unused) {
                                 Log.d(TAG,"Onsuccess:User profile is created for "+userID);
                             }
                         }).addOnFailureListener(new OnFailureListener() {
                             @Override
                             public void onFailure(@NonNull Exception e) {
                                 Log.d(TAG,"Onsuccess: "+e.toString());
                             }
                         });

                         startActivity(new Intent(getApplicationContext(),Result.class));

                     }
                     else{
                         Toast.makeText(Register.this,"Error"+task.getException().getMessage(),Toast.LENGTH_SHORT);
                     }
                 }
             });
             progbar.setVisibility(View.VISIBLE);


         }




     });



    }
}