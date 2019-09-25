package com.kawig.tourismapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class AdminPlace extends AppCompatActivity {
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_place);

        mRecyclerView=(RecyclerView) findViewById(R.id.recyclerview_place);
        new FirebaseDatabasePlace().readPlace(new FirebaseDatabasePlace.DataStatus() {
            @Override
            public void DataIsLoaded(List<Place> places, List<String> keys) {
                new RecyclerViewPlace_Config().setConfig(mRecyclerView, AdminPlace.this,places,keys);
            }

            @Override
            public void DataIsInserted() {

            }

            @Override
            public void DataIsUpdated() {

            }

            @Override
            public void DataIsDeleted() {

            }
        });

    }
}