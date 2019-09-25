package com.kawig.tourismapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Adplace extends AppCompatActivity {
    public Button button10;
    public Button button11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adplace);

        button10=(Button)findViewById(R.id.AddPl);
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPlaceAdd();
            }
        });

        button11= (Button)findViewById(R.id.ViewPl);
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPlaceList();
            }
        });


    }
    public void openPlaceAdd(){
        Intent intent = new Intent(this,NewPlaceActivity.class);
        startActivity(intent);
    }

    public void openPlaceList(){
        Intent intent = new Intent(this,AdminPlace.class);
        startActivity(intent);
    }
}
