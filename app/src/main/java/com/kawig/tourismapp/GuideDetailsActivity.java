package com.kawig.tourismapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class GuideDetailsActivity extends AppCompatActivity {
    private EditText mGname_editTxt;
    private EditText mGaddress_editTxt;
    private EditText mGlanguage_editTxt;
    private EditText mGcity_editTxt;
    private EditText mGno_editTxt;
    private Button mGupdate_btn;
    private Button mGdele_btn;

    private String key;
    private String gname;
    private String gaddress;
    private String glanguage;
    private String gcity;
    private String gno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_details);

        key = getIntent().getStringExtra("key");
        gname = getIntent().getStringExtra("gname");
        gaddress = getIntent().getStringExtra("gaddress");
        glanguage = getIntent().getStringExtra("glanguage");
        gcity = getIntent().getStringExtra("gcity");
        gno = getIntent().getStringExtra("gno");

        mGname_editTxt = (EditText) findViewById(R.id.gname_editTxt);
        mGname_editTxt.setText(gname);
        mGaddress_editTxt = (EditText) findViewById(R.id.gaddress_editTxt);
        mGaddress_editTxt.setText(gaddress);
        mGlanguage_editTxt = (EditText) findViewById(R.id.glanguage_editTxt);
        mGlanguage_editTxt.setText(glanguage);
        mGcity_editTxt = (EditText) findViewById(R.id.gcity_editTxt);
        mGcity_editTxt.setText(gcity);
        mGno_editTxt = (EditText) findViewById(R.id.gno_editTxt);
        mGno_editTxt.setText(gno);

        mGupdate_btn = (Button) findViewById(R.id.gupdate_btn);
        mGdele_btn = (Button) findViewById(R.id.gdele_btn);

        mGupdate_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Guide guide = new Guide();
                guide.setGname(mGname_editTxt.getText().toString());
                guide.setGaddress(mGaddress_editTxt.getText().toString());
                guide.setGlanguage(mGlanguage_editTxt.getText().toString());
                guide.setGcity(mGcity_editTxt.getText().toString());
                guide.setGno(mGno_editTxt.getText().toString());

                new FirebaseDatabaseGuide().updateGuide(key, guide, new FirebaseDatabaseGuide.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<Guide> guides, List<String> keys) {

                    }

                    @Override
                    public void DataIsInserted() {

                    }

                    @Override
                    public void DataIsUpdated() {
                        Toast.makeText(GuideDetailsActivity.this,"Guide Updated",Toast.LENGTH_LONG).show();
                        finish();
                        return;

                    }

                    @Override
                    public void DataIsDeleted() {

                    }
                });
            }
        });
        mGdele_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new FirebaseDatabaseGuide().deleteGuide(key, new FirebaseDatabaseGuide.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<Guide> guides, List<String> keys) {

                    }

                    @Override
                    public void DataIsInserted() {

                    }

                    @Override
                    public void DataIsUpdated() {

                    }

                    @Override
                    public void DataIsDeleted() {
                        Toast.makeText(GuideDetailsActivity.this, "Guide Deleted", Toast.LENGTH_LONG).show();
                        finish();
                        return;
                    }
                } );
            }
        });

    }

    }
