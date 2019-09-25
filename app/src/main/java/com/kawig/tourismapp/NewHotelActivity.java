package com.kawig.tourismapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class NewHotelActivity extends AppCompatActivity {
    private EditText mHname_editTxt;
    private EditText mHlocation_editTxt;
    private EditText mHdetails_editTxt;
    private EditText mHno_editTxt;
    private Button mHadd_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_hotel);
        mHname_editTxt = (EditText) findViewById(R.id.hname_editTxt);
        mHlocation_editTxt = (EditText) findViewById(R.id.hloc_editTxt);
        mHdetails_editTxt = (EditText) findViewById(R.id.hdet_editTxt);
        mHno_editTxt = (EditText) findViewById(R.id.hno_editTxt);
        mHadd_btn = (Button) findViewById(R.id.hadd_btn);

        mHadd_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Hotel hotel = new Hotel();
                hotel.setHname(mHname_editTxt.getText().toString());
                hotel.setHlocation(mHlocation_editTxt.getText().toString());
                hotel.setHdetails(mHdetails_editTxt.getText().toString());
                hotel.setHno(mHno_editTxt.getText().toString());
                new FirebaseDatabaseHotel().addHotel(hotel, new FirebaseDatabaseHotel.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<Hotel> hotels, List<String> keys) {

                    }

                    @Override
                    public void DataIsInserted() {
                        Toast.makeText(NewHotelActivity.this, "The Hotel Record Has " +
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
