package com.kawig.tourismapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Adguide extends AppCompatActivity {
    public Button button13;
    public Button button14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adguide);

        button13=(Button)findViewById(R.id.AddGu);
        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewGuideActivity();
            }
        });

        button14= (Button)findViewById(R.id.viewGu);
        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAdminGuide();
            }
        });


    }
    public void openNewGuideActivity(){
        Intent intent = new Intent(this,NewGuideActivity.class);
        startActivity(intent);
    }

    public void openAdminGuide(){
        Intent intent = new Intent(this,AdminGuide.class);
        startActivity(intent);
    }
}
