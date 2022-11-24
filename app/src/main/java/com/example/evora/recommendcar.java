package com.example.evora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.*;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class recommendcar extends AppCompatActivity {
    Button gbtn;
    ImageView car;
    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Bundle bundle = getIntent().getExtras();

//        String num=bundle.getString("rand");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendcar);
        car = findViewById(R.id.carimg);
        tv = findViewById(R.id.cardes);




char chh=' ';
        try {

            URL url = new URL("https://evil-adults-join-103-177-203-246.loca.lt/predict");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");
            con.setDoOutput(true);
            String jsonInputString = "{\"distance_per_day\": 100, \"resale_value\": 10, \"ev_stations\": 20}";
            try (OutputStream os = con.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println(response.toString());
                for (int i = 0; i < response.length(); i++) {
                     char ch = response.charAt(i);
                    Toast.makeText(this, "value of ch is "+ch, Toast.LENGTH_SHORT).show();
                    if (Character.isDigit(ch)) {
                        System.out.println(ch);
                        chh = ch;
                        //                            Thread.sleep(5000);
                    }
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        Integer num= chh == ' ' ? -1 : chh - '0';
        System.out.println(num);
        if(num==0){
                    car.setImageResource(R.drawable.tiger);
                    tv.append("Name : Tata tiger \n Battery Capacity:20kwh \n Charging time: 4 hours \n price: 7 lakh \n seating capacity 5");


                }
                else if(num==1){
                    car.setImageResource(R.drawable.tiago);
                    tv.append("Name : Tata tiago \n Battery Capacity:19kwh \n Charging time: 4.5 hours \n price: 9 lakh \n seating capacity 5");


                }
                else if(num==2){
                    car.setImageResource(R.drawable.nexon);
                    tv.append("Name : Tata Nexon \n Battery Capacity:25kwh \n Charging time: 4.5 hours \n price: 15 lakh \n seating capacity 5");


                }
                else if(num==3){
                    car.setImageResource(R.drawable.mgzs);
                    tv.append("Name : Mg ZS \n Battery Capacity:20kwh \n Charging time: 4 hours \n price: 7 lakh \n seating capacity 5");


                }
                else if(num==4){
                    car.setImageResource(R.drawable.kona);
                    tv.append("Name : Hyundai Kona \n Battery Capacity:20kwh \n Charging time: 4 hours \n price: 7 lakh \n seating capacity 5");


                }
                else if(num==5){
                    car.setImageResource(R.drawable.atto);
                    tv.append("Name : Atto 3 \n Battery Capacity:20kwh \n Charging time: 4 hours \n price: 7 lakh \n seating capacity 5");


                }
                else if(num==6){
                    car.setImageResource(R.drawable.minicooper);
                    tv.append("Name : Mini cooper  \n Battery Capacity:20kwh \n Charging time: 4 hours \n price: 7 lakh \n seating capacity 5");


                }
                else if(num==7){
                    car.setImageResource(R.drawable.xc40);
                    tv.append("Name : Volvo xc40 \n Battery Capacity:20kwh \n Charging time: 4 hours \n price: 7 lakh \n seating capacity 5");


                }
                else if(num==8){
                    car.setImageResource(R.drawable.kiaev6);
                    tv.append("Name : kia ev6 \n Battery Capacity:20kwh \n Charging time: 4 hours \n price: 7 lakh \n seating capacity 5");


                }
                else if(num==9){
                    car.setImageResource(R.drawable.bmwi4);
                    tv.append("Name : bmw i4 \n Battery Capacity:20kwh \n Charging time: 4 hours \n price: 7 lakh \n seating capacity 5");


                }


            }


}