package com.kawig.tourismapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class NewPlaceActivity extends AppCompatActivity {
    private EditText mPname_editTxt;
    private EditText mPlocation_editTxt;
    private EditText mPdetails_editTxt;
    private EditText mPno_editTxt;
    private Button mPadd_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_place);

        mPname_editTxt = (EditText) findViewById(R.id.pname_editTxt);
        mPlocation_editTxt = (EditText) findViewById(R.id.plocation_editTxt);
        mPdetails_editTxt = (EditText) findViewById(R.id.pdetails_editTxt);
        mPno_editTxt = (EditText) findViewById(R.id.pno_editTxt);
        mPadd_btn = (Button) findViewById(R.id.padd_btn);

        mPadd_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Place place = new Place();
                place.setPname(mPname_editTxt.getText().toString());
                place.setPloc(mPlocation_editTxt.getText().toString());
                place.setPdet(mPdetails_editTxt.getText().toString());
                place.setPno(mPno_editTxt.getText().toString());
                new FirebaseDatabasePlace().addPlace(place, new FirebaseDatabasePlace.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<Place> places, List<String> keys) {

                    }

                    @Override
                    public void DataIsInserted() {
                        Toast.makeText(NewPlaceActivity.this, "The Place Record Has " +
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
