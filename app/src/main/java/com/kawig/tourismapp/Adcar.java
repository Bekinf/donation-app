package com.kawig.tourismapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Adcar extends AppCompatActivity {
    public Button button23;
    public Button button24;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adcar);
        button23=(Button)findViewById(R.id.AddCa);
        button23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewCarActivity();
            }
        });

        button24= (Button)findViewById(R.id.viewCa);
        button24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAdminCar();
            }
        });


    }
    public void openNewCarActivity(){
        Intent intent = new Intent(this,NewCarActivity.class);
        startActivity(intent);
    }

    public void openAdminCar(){
        Intent intent = new Intent(this,AdminCar.class);
        startActivity(intent);
    }
}