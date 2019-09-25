package com.kawig.tourismapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

public class CarListActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_list);

        mAuth = FirebaseAuth.getInstance();

        mRecyclerView=(RecyclerView) findViewById(R.id.recyclerview_cars);
        new FirebaseDatabaseCar().readCars(new FirebaseDatabaseCar.DataStatus() {
            @Override
            public void DataIsLoaded(List<Car> cars, List<String> keys) {
                findViewById(R.id.loading_cars_pb).setVisibility(View.GONE);
                new UserRecyclerViewCar_Config().setConfig(mRecyclerView,CarListActivity.this,cars,keys);
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
