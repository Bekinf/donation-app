package com.kawig.tourismapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class CarDetailsActivity extends AppCompatActivity {
    private EditText mCtype_editTxt;
    private EditText mCnumber_editTxt;
    private EditText mCno_editTxt;
    private EditText mCfaci_editTxt;
    private Button mCupdate_btn;
    private Button mCdele_btn;

    private String key;
    private String ctype;
    private String cnum;
    private String cno;
    private String cfaci;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_details);

        key = getIntent().getStringExtra("key");
        ctype = getIntent().getStringExtra("ctype");
        cnum = getIntent().getStringExtra("cnum");
        cfaci = getIntent().getStringExtra("cfaci");
        cno = getIntent().getStringExtra("cno");

        mCtype_editTxt = (EditText) findViewById(R.id.ctype_editTxt);
        mCtype_editTxt.setText(ctype);
        mCnumber_editTxt = (EditText) findViewById(R.id.cnumber_editTxt);
        mCnumber_editTxt.setText(cnum);
        mCno_editTxt = (EditText) findViewById(R.id.cno_editTxt);
        mCno_editTxt.setText(cno);
        mCfaci_editTxt = (EditText) findViewById(R.id.cfaci_editTxt);
        mCfaci_editTxt.setText(cfaci);

        mCupdate_btn = (Button) findViewById(R.id.cupdate_btn);
        mCdele_btn = (Button) findViewById(R.id.cdele_btn);


        mCupdate_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Car car = new Car();
                car.setCtype(mCtype_editTxt.getText().toString());
                car.setCnumber(mCnumber_editTxt.getText().toString());
                car.setCfaci(mCfaci_editTxt.getText().toString());
                car.setCno(mCno_editTxt.getText().toString());

                new FirebaseDatabaseCar().updateCar(key, car, new FirebaseDatabaseCar.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<Car> cars, List<String> keys) {

                    }

                    @Override
                    public void DataIsInserted() {

                    }

                    @Override
                    public void DataIsUpdated() {
                        Toast.makeText(CarDetailsActivity.this,"Vehicle Updated",Toast.LENGTH_LONG).show();
                        finish();
                        return;

                    }

                    @Override
                    public void DataIsDeleted() {

                    }
                });
            }
        });
        mCdele_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new FirebaseDatabaseCar().deleteCar(key, new FirebaseDatabaseCar.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<Car> cars, List<String> keys) {

                    }

                    @Override
                    public void DataIsInserted() {

                    }

                    @Override
                    public void DataIsUpdated() {

                    }

                    @Override
                    public void DataIsDeleted() {
                        Toast.makeText(CarDetailsActivity.this, "Vehicle Deleted", Toast.LENGTH_LONG).show();
                        finish();
                        return;
                    }
                } );
            }
        });

    }

}
