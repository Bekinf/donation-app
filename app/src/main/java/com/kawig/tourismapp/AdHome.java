package com.kawig.tourismapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdHome extends AppCompatActivity {
    public Button button6;
    public Button button7;
    public Button button8;
    public Button button9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_home);

        button6=(Button)findViewById(R.id.Apl);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAdplace();
            }
        });

        button7= (Button)findViewById(R.id.Aho);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAdhotel();
            }
        });
        button8=(Button)findViewById(R.id.Acr);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAdcar();
            }
        });

        button9= (Button)findViewById(R.id.Agu);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAdguide();
            }
        });
    }
    public void openAdplace(){
        Intent intent = new Intent(this,Adplace.class);
        startActivity(intent);
    }

    public void openAdhotel(){
        Intent intent = new Intent(this,Adhotel.class);
        startActivity(intent);
    }

    public void openAdcar(){
        Intent intent = new Intent(this,Adcar.class);
        startActivity(intent);

    }

    public void openAdguide(){
        Intent intent = new Intent(this,Adguide.class);
        startActivity(intent);
    }
}
