package com.kawig.tourismapp;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseDatabaseCar {

    private FirebaseDatabase mDatabase;
    private DatabaseReference mRerenceCars;
    private List<Car> cars=new ArrayList<>();

    public interface DataStatus{
        void DataIsLoaded(List<Car> cars, List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }

    public FirebaseDatabaseCar() {
        mDatabase =FirebaseDatabase.getInstance();
        mRerenceCars =mDatabase.getReference("cars");
    }
    public void readCars(final DataStatus dataStatus){
        mRerenceCars.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                cars.clear();
                List<String>keys = new ArrayList<>();
                for (DataSnapshot keyNode : dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    Car car=keyNode.getValue(Car.class);
                    cars.add(car);
                }
                dataStatus.DataIsLoaded(cars,keys);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    public void addCar(Car car,final FirebaseDatabaseCar.DataStatus dataStatus){
        String key = mRerenceCars.push().getKey();
        mRerenceCars.child(key).setValue(car).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                dataStatus.DataIsInserted();
            }
        });
    }
    public void updateCar(String key,Car car,final FirebaseDatabaseCar.DataStatus dataStatus){
        mRerenceCars.child(key).setValue(car).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                dataStatus.DataIsUpdated();
            }
        });
    }
    public void deleteCar(String key,final FirebaseDatabaseCar.DataStatus dataStatus){
        mRerenceCars.child(key).setValue(null).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                dataStatus.DataIsDeleted();
            }
        });
    }
}

