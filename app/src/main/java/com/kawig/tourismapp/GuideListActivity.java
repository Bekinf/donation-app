package com.kawig.tourismapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

public class GuideListActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_list);

        mAuth = FirebaseAuth.getInstance();

        mRecyclerView=(RecyclerView) findViewById(R.id.recyclerview_guides);
        new FirebaseDatabaseGuide().readGuides(new FirebaseDatabaseGuide.DataStatus() {
            @Override
            public void DataIsLoaded(List<Guide> guides, List<String> keys) {
                findViewById(R.id.loading_guides_pb).setVisibility(View.GONE);
                new UserRecyclerViewGuide_Config().setConfig(mRecyclerView,GuideListActivity.this,guides,keys);
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
