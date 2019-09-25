package com.kawig.tourismapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.List;

public class PlaceListActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_list);
        mRecyclerView =(RecyclerView) findViewById(R.id.recyclerview_place);
        new FirebaseDatabasePlace().readPlace(new FirebaseDatabasePlace.DataStatus() {
            @Override
            public void DataIsLoaded(List<Place> places, List<String> keys) {
                findViewById(R.id.loading_places_pb).setVisibility(View.GONE);
                new UsreRecyclerViewPlace_Config().setConfig(mRecyclerView,PlaceListActivity.this,places,keys);
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
