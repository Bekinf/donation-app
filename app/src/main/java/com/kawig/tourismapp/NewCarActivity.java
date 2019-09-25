package com.kawig.tourismapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class NewCarActivity extends AppCompatActivity {
    private EditText mCtype_editTxt;
    private EditText mCnumber_editTxt;
    private EditText mCno_editTxt;
    private EditText mCfaci_editTxt;

    private Button mCadd_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_car);

        mCtype_editTxt = (EditText) findViewById(R.id.ctype_editTxt);
        mCnumber_editTxt = (EditText) findViewById(R.id.cnumber_editTxt);
        mCno_editTxt = (EditText) findViewById(R.id.cno_editTxt);
        mCfaci_editTxt = (EditText) findViewById(R.id.cfaci_editTxt);

        mCadd_btn = (Button) findViewById(R.id.cadd_btn);

        mCadd_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Car car = new Car();
                car.setCtype(mCtype_editTxt.getText().toString());
                car.setCnumber(mCnumber_editTxt.getText().toString());
                car.setCno(mCno_editTxt.getText().toString());
                car.setCfaci(mCfaci_editTxt.getText().toString());

                new FirebaseDatabaseCar().addCar(car, new FirebaseDatabaseCar.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<Car> cars, List<String> keys) {

                    }

                    @Override
                    public void DataIsInserted() {
                        Toast.makeText(NewCarActivity.this, "The Car Record Has " +
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
