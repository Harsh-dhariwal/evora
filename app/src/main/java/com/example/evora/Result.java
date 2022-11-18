package com.example.evora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Result extends AppCompatActivity {

    RadioGroup rg;
    Button msubbtn;
    RadioButton rbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

       rg=(RadioGroup)findViewById(R.id.rg);
        msubbtn=findViewById(R.id.subbtn);
        int selectedId=rg.getCheckedRadioButtonId();
        rbtn=(RadioButton)findViewById(selectedId);

        msubbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Result.this, rbtn.getText(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}