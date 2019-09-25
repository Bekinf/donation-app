package com.kawig.tourismapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class PlaceDetailsActivity extends AppCompatActivity {
    private EditText mPname_editTxt;
    private EditText mPlocation_editTxt;
    private EditText mPdetails_editTxt;
    private EditText mPno_editTxt;
    private Button mPupdate_btn;
    private Button mPdele_btn;

    private String key;
    private String pname;
    private String plocation;
    private String pdetails;
    private String pno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_details);

        key = getIntent().getStringExtra("key");
        pname = getIntent().getStringExtra("pname");
        plocation = getIntent().getStringExtra("plocation");
        pdetails = getIntent().getStringExtra("pdetails");
        pno = getIntent().getStringExtra("pno");

        mPname_editTxt = (EditText) findViewById(R.id.pname_editTxt);
        mPname_editTxt.setText(pname);
        mPlocation_editTxt = (EditText) findViewById(R.id.plocation_editTxt);
        mPlocation_editTxt.setText(plocation);
        mPdetails_editTxt = (EditText) findViewById(R.id.pdetails_editTxt);
        mPdetails_editTxt.setText(pdetails);
        mPno_editTxt = (EditText) findViewById(R.id.pno_editTxt);
        mPno_editTxt.setText(pno);

        mPupdate_btn = (Button) findViewById(R.id.pupdate_btn);
        mPdele_btn = (Button) findViewById(R.id.pdele_btn);

        mPupdate_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Place place = new Place();
                place.setPname(mPname_editTxt.getText().toString());
                place.setPloc(mPlocation_editTxt.getText().toString());
                place.setPdet(mPdetails_editTxt.getText().toString());
                place.setPno(mPno_editTxt.getText().toString());

                new FirebaseDatabasePlace().updatePlace(key, place, new FirebaseDatabasePlace.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<Place> places, List<String> keys) {

                    }

                    @Override
                    public void DataIsInserted() {

                    }

                    @Override
                    public void DataIsUpdated() {
                        Toast.makeText(PlaceDetailsActivity.this,"Place Updated",Toast.LENGTH_LONG).show();
                        finish();
                        return;

                    }

                    @Override
                    public void DataIsDeleted() {

                    }
                });
            }
        });
        mPdele_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new FirebaseDatabasePlace().deletePlace(key, new FirebaseDatabasePlace.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<Place> places, List<String> keys) {

                    }

                    @Override
                    public void DataIsInserted() {

                    }

                    @Override
                    public void DataIsUpdated() {

                    }

                    @Override
                    public void DataIsDeleted() {
                        Toast.makeText(PlaceDetailsActivity.this, "Place Deleted", Toast.LENGTH_LONG).show();
                        finish();
                        return;
                    }
                } );
            }
        });
    }
}
