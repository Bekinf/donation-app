package com.kawig.tourismapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class HotelDetailsActivity extends AppCompatActivity {
    private EditText mHname_editTxt;
    private EditText mHlocation_editTxt;
    private EditText mHdetails_editTxt;
    private EditText mHno_editTxt;
    private Button mHupdate_btn;
    private Button mHdele_btn;

    private String key;
    private String hname;
    private String hloc;
    private String hdet;
    private String hno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_details);


        key = getIntent().getStringExtra("key");
        hname = getIntent().getStringExtra("hname");
        hloc = getIntent().getStringExtra("hlocation");
        hdet = getIntent().getStringExtra("hdetails");
        hno = getIntent().getStringExtra("hno");

        mHname_editTxt = (EditText) findViewById(R.id.hname_editTxt);
        mHname_editTxt.setText(hname);
        mHlocation_editTxt = (EditText) findViewById(R.id.hloc_editTxt);
        mHlocation_editTxt.setText(hloc);
        mHdetails_editTxt = (EditText) findViewById(R.id.hdet_editTxt);
        mHdetails_editTxt.setText(hdet);
        mHno_editTxt = (EditText) findViewById(R.id.hno_editTxt);
        mHno_editTxt.setText(hno);

        mHupdate_btn = (Button) findViewById(R.id.hupdate_btn);
        mHdele_btn = (Button) findViewById(R.id.hdele_btn);

        mHupdate_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Hotel hotel = new Hotel();
                hotel.setHname(mHname_editTxt.getText().toString());
                hotel.setHlocation(mHlocation_editTxt.getText().toString());
                hotel.setHdetails(mHdetails_editTxt.getText().toString());
                hotel.setHno(mHno_editTxt.getText().toString());

                new FirebaseDatabaseHotel().updateHotel(key, hotel, new FirebaseDatabaseHotel.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<Hotel> hotels, List<String> keys) {

                    }

                    @Override
                    public void DataIsInserted() {

                    }

                    @Override
                    public void DataIsUpdated() {
                        Toast.makeText(HotelDetailsActivity.this,"Hotel Updated",Toast.LENGTH_LONG).show();
                        finish();
                        return;

                    }

                    @Override
                    public void DataIsDeleted() {

                    }
                });
            }
        });
        mHdele_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new FirebaseDatabaseHotel().deleteHotel(key, new FirebaseDatabaseHotel.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<Hotel> hotels, List<String> keys) {

                    }

                    @Override
                    public void DataIsInserted() {

                    }

                    @Override
                    public void DataIsUpdated() {

                    }

                    @Override
                    public void DataIsDeleted() {
                        Toast.makeText(HotelDetailsActivity.this, "Hotel Deleted", Toast.LENGTH_LONG).show();
                        finish();
                        return;
                    }
                } );
            }
        });

    }

}
