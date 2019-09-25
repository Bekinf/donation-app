package com.kawig.tourismapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class NewGuideActivity extends AppCompatActivity {
    private EditText mGname_editTxt;
    private EditText mGaddress_editTxt;
    private EditText mGlanguage_editTxt;
    private EditText mGcity_editTxt;
    private EditText mGno_editTxt;
    private Button mGadd_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_guide);

        mGname_editTxt = (EditText) findViewById(R.id.gname_editTxt);
        mGaddress_editTxt = (EditText) findViewById(R.id.gaddress_editTxt);
        mGlanguage_editTxt = (EditText) findViewById(R.id.glanguage_editTxt);
        mGcity_editTxt = (EditText) findViewById(R.id.gcity_editTxt);
        mGno_editTxt = (EditText) findViewById(R.id.gno_editTxt);
        mGadd_btn = (Button) findViewById(R.id.gadd_btn);

        mGadd_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Guide guide = new Guide();
                guide.setGname(mGname_editTxt.getText().toString());
                guide.setGaddress(mGaddress_editTxt.getText().toString());
                guide.setGcity(mGcity_editTxt.getText().toString());
                guide.setGlanguage(mGlanguage_editTxt.getText().toString());
                guide.setGno(mGno_editTxt.getText().toString());
                new FirebaseDatabaseGuide().addGuide(guide, new FirebaseDatabaseGuide.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<Guide> guides, List<String> keys) {

                    }

                    @Override
                    public void DataIsInserted() {
                        Toast.makeText(NewGuideActivity.this, "The Guide Record Has " +
                                "Been Inserted Successfully", Toast.LENGTH_LONG).show();
                        finish();
                        return;

                    }

                    @Override
                    public void DataIsUpdated() {

                    }

                    @Override
                    public void DataIsDeleted() {

                    }
                });
            }
        });
    }
}
