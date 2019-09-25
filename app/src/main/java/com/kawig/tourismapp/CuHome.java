package com.kawig.tourismapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CuHome extends AppCompatActivity {
    public Button button2;
    public Button button3;
    public Button button4;
    public Button button5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cu_home);
        button2=(Button)findViewById(R.id.pl);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPlace();
            }
        });

        button3= (Button)findViewById(R.id.ho);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHotel();
            }
        });
        button4=(Button)findViewById(R.id.cr);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCar();
            }
        });

        button5= (Button)findViewById(R.id.gu);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGuide();
            }
        });
    }
    public void openPlace(){
        Intent intent = new Intent(this, PlaceListActivity.class);
        startActivity(intent);
    }

    public void openHotel(){
        Intent intent = new Intent(this, HotelListActivity.class);
        startActivity(intent);
    }

    public void openCar(){
        Intent intent = new Intent(this, CarListActivity.class);
        startActivity(intent);
    }

    public void openGuide(){
        Intent intent = new Intent(this,GuideListActivity.class);
        startActivity(intent);
    }
}
