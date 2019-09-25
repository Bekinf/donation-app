package com.kawig.tourismapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class AdminCar extends AppCompatActivity {
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_car);

        mRecyclerView=(RecyclerView) findViewById(R.id.recyclerview_cars);
        new FirebaseDatabaseCar().readCars(new FirebaseDatabaseCar.DataStatus() {
            @Override
            public void DataIsLoaded(List<Car> cars, List<String> keys) {
                new RecyclerViewCar_Config().setConfig(mRecyclerView, AdminCar.this,cars,keys);
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
