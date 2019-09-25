package com.kawig.tourismapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.List;

public class AdminHotel extends AppCompatActivity {
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_hotel);
        mRecyclerView=(RecyclerView) findViewById(R.id.recyclerview_hotels);
        new FirebaseDatabaseHotel().readHotels(new FirebaseDatabaseHotel.DataStatus() {
            @Override
            public void DataIsLoaded(List<Hotel> hotels, List<String> keys) {
                findViewById(R.id.loading_hotels_pb).setVisibility(View.GONE);
                new RecyclerViewHotel_Config().setConfig(mRecyclerView,AdminHotel.this,hotels,keys);
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
