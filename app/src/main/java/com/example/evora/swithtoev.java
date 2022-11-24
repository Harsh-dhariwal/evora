package com.example.evora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class swithtoev extends AppCompatActivity {
Button sb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swithtoev);
        sb=findViewById(R.id.switchbt);

        sb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(swithtoev.this, user_details.class));
            }
        });
    }
}