package com.example.evora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.squareup.picasso.Picasso;


public class Result extends AppCompatActivity {

    RadioGroup mrg,mcity,mfuel;
    Button msubbtn;
    RadioButton rbtn;
    TextView tv,chp;
    CheckBox parkcheck;
    EditText cityt,hight;
    BarChart bc;
    ImageView ress1,ress2,ress3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
//        setupPieChart();
//        loadPieChartData();

        mrg=findViewById(R.id.rg);
        msubbtn=findViewById(R.id.subbtn);
        tv=findViewById(R.id.result);
        parkcheck=findViewById(R.id.parkingcheck);
        mcity=findViewById(R.id.citychoice);
        cityt=findViewById(R.id.citytravel);
        hight=findViewById(R.id.highwaytravel);
        mfuel=findViewById(R.id.fuelchoice);
        ress1=findViewById(R.id.res1);
        chp=findViewById(R.id.cityhighpref);
        ress2=findViewById(R.id.res2);
        ress3=findViewById(R.id.res3);




        msubbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioId=mrg.getCheckedRadioButtonId();
                rbtn=findViewById(radioId);
                tv.setText(rbtn.getText());
                if(parkcheck.isChecked()) {
                    tv.append(" \n parking available");
                }
                radioId=mcity.getCheckedRadioButtonId();
                rbtn=findViewById(radioId);
                tv.append("\n"+rbtn.getText());
                tv.append("\n city travel" + cityt.getText());
                tv.append("\n Highway travel" + hight.getText());
                radioId=mfuel.getCheckedRadioButtonId();
                rbtn=findViewById(radioId);
                tv.append("\n Fuel used right now :"+rbtn.getText());
                String fuel= (String) rbtn.getText();


//                setting the highway travel and city travel comparison pie chart
//                String image_url="https://quickchart.io/chart?c={type:%27pie%27,data:{labels:[%27City_Tavel%27,%27Highway_travel%27],datasets:[{data:[50,60]}]}}";

                String image_url="https://quickchart.io/chart?c={type:%27pie%27,data:{labels:[%27City_Tavel%27,%27Highway_travel%27],datasets:[{data:["+cityt.getText()+","+hight.getText()+"]}]}}";
                Picasso.get().load(image_url).fit().into(ress1);

                //price comparison for city travel and highway travel

                int citytr=Integer.parseInt(cityt.getText().toString());
                int hightr=Integer.parseInt(hight.getText().toString());
                int totaldist=citytr+hightr;
            tv.append(Integer.toString(citytr*2));
                String cityhightravel="https://quickchart.io/chart?c={type:'bar',data:{labels:['city_travel','highway_travel'],datasets:[{label:'Travel Distance',data:["+Integer.toString(citytr)+","+Integer.toString(hightr)+"]}]}}";
                Picasso.get().load(cityhightravel).fit().into(ress2);



                //cost produced due to petrol vs electric vehicle

                String costcomp="https://quickchart.io/chart?c={type:%27pie%27,data:{labels:[%27Cost for engine car%27,%27Cost for electric vehicle%27],datasets:[{data:["+Integer.toString(totaldist*15)+","+Integer.toString(totaldist*2)+"]}]}}";
                Picasso.get().load(costcomp).fit().into(ress3);



            }
        });



    }




    public void checkbutton(View v){
        int radioId=mrg.getCheckedRadioButtonId();
        rbtn=findViewById(radioId);
        Toast.makeText(this, "selected ratio button "+rbtn.getText(), Toast.LENGTH_SHORT).show();
    }
}