package com.example.evora;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileReader;
import java.util.HashMap;

public class user_details extends AppCompatActivity {
    Button bt;
    EditText textview;
    TextView t;

    public String res() throws Exception {
        String command = "python post.py";
        Process p = Runtime.getRuntime().exec(command);
        Thread.sleep(3000);

        // Passing the path to the file as a parameter
        FileReader fr = new FileReader(
                "filename.txt");

        // Declaring loop variable
        int i;
        // Holds true till there is nothing to read
        while ((i = fr.read()) != -1)

            // Print all the content of a file
            return(Integer.toString(i));
        return "";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        textview = findViewById(R.id.editTextNumber);
        bt = findViewById(R.id.button2);
        t = findViewById(R.id.textView9);

        Bundle bundle = getIntent().getExtras();
        String number = bundle.getString("num");




 String text;

        Spinner dropdown = findViewById(R.id.spinner1);
//create a list of items for the spinner.
        String[] items = new String[]{"Delhi", "Mumbai", "Hyderabad","Banglore"};
//create an adapter to describe how the items are displayed, adapters are used in several places in android.
//There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
//set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapter);
        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // Toast.makeText(car_rto.this, text, Toast.LENGTH_SHORT).show();
                String textt=dropdown.getSelectedItem().toString();


                bundle.putString("s",textt);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner dropdown2 = findViewById(R.id.spinner2);

//create a list of items for the spinner.
        String[] items2 = new String[]{"Delhi", "Mumbai", "Hyderabad","Banglore"};
//create an adapter to describe how the items are displayed, adapters are used in several places in android.
//There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
//set the spinners adapter to the previously created one.
        dropdown2.setAdapter(adapter2);
        dropdown2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String text2=dropdown2.getSelectedItem().toString();

                bundle.putString("e",text2);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


//        final String URL = "https://clear-beers-sell-103-177-203-246.loca.lt/";
//        HashMap<String, Integer> params = new HashMap<String, Integer>();
//        params.put("distance_per_day",150);
//        params.put("resale_value",50);
//        params.put("ev_stations",11);
//
//        user_details ob = new user_details();
//        try {
////            Toast.makeText(ob, ob.res(), Toast.LENGTH_SHORT).show();
//            Context context = getApplicationContext();
//            CharSequence text2 = "" + ob.res();
//            int duration = Toast.LENGTH_SHORT;
//            Toast toast = Toast.makeText(context,text2,duration);
//            toast.show();
//            System.out.println(ob.res() + "-----------------result-------------------");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//
//        JsonObjectRequest req = new JsonObjectRequest(URL, new JSONObject(params),
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        try {
//                            VolleyLog.v("Response:%n %s", response.toString(4));
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                VolleyLog.e("Error: ", error.getMessage());
//            }
//        });


        bt.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                if(bundle.getString("s").equals(bundle.getString("e"))){
                    Toast.makeText(getApplicationContext(), "Starting and ending destinations are same !", Toast.LENGTH_SHORT).show();
                }



                if ( ( textview.getText().toString().matches("")))
                {
                   textview.setError("distance cannot be empty");
                    Toast.makeText(getApplicationContext(), "Distance field cannot be empty", Toast.LENGTH_SHORT).show();
                }
                else
                {


                Intent i = new Intent(user_details.this, anayltics.class);
//                Bundle bundlee = new Bundle();
                bundle.putString("travel",textview.getText().toString());


                    try {
//                        bundle.putString(ob.res(),"rand");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    bundle.putString(number,"num");
//Add your data to bundle
//                bundle.putString("num",);
////Add the bundle to the intent
                i.putExtras(bundle);
                startActivity(i);
            }
            }
        });

//        private void postData(int distance_per_day, int resale_value, int ev_stations) {
//
//            // below line is for displaying our progress bar.
//            loadingPB.setVisibility(View.VISIBLE);
//
//            // on below line we are creating a retrofit
//            // builder and passing our base url
//            Retrofit retrofit = new Retrofit.Builder()
//                    .baseUrl("https://reqres.in/api/")
//                    // as we are sending data in json format so
//                    // we have to add Gson converter factory
//                    .addConverterFactory(GsonConverterFactory.create())
//                    // at last we are building our retrofit builder.
//                    .build();
//            // below line is to create an instance for our retrofit api class.
//            RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
//
//            // passing data from our text fields to our modal class.
//            DataModal modal = new DataModal(name, job);
//
//            // calling a method to create a post and passing our modal class.
//            Call<DataModal> call = retrofitAPI.createPost(modal);
//
//            // on below line we are executing our method.
//            call.enqueue(new Callback<DataModal>() {
//                @Override
//                public void onResponse(Call<DataModal> call, Response<DataModal> response) {
//                    // this method is called when we get response from our api.
//                    Toast.makeText(MainActivity.this, "Data added to API", Toast.LENGTH_SHORT).show();
//
//                    // below line is for hiding our progress bar.
//                    loadingPB.setVisibility(View.GONE);
//
//                    // on below line we are setting empty text
//                    // to our both edit text.
//                    jobEdt.setText("");
//                    nameEdt.setText("");
//
//                    // we are getting response from our body
//                    // and passing it to our modal class.
//                    DataModal responseFromAPI = response.body();
//
//                    // on below line we are getting our data from modal class and adding it to our string.
//                    String responseString = "Response Code : " + response.code() + "\nName : " + responseFromAPI.getName() + "\n" + "Job : " + responseFromAPI.getJob();
//
//                    // below line we are setting our
//                    // string to our text view.
//                    responseTV.setText(responseString);
//                }
//
//                @Override
//                public void onFailure(Call<DataModal> call, Throwable t) {
//                    // setting text to our text view when
//                    // we get error response from API.
//                    responseTV.setText("Error found is : " + t.getMessage());
//                }
//            });
//        }






    }
}