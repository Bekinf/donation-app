package com.kawig.tourismapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class AdminGuide extends AppCompatActivity {
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_guide);

        mRecyclerView=(RecyclerView) findViewById(R.id.recyclerview_guides);
        new FirebaseDatabaseGuide().readGuides(new FirebaseDatabaseGuide.DataStatus() {
            @Override
            public void DataIsLoaded(List<Guide> guides, List<String> keys) {
                new RecyclerViewGuide_Config().setConfig(mRecyclerView, AdminGuide.this,guides,keys);
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
