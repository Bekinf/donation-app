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

public class FirebaseDatabaseHotel {
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferenceHotels;
    private List<Hotel> hotels=new ArrayList<>();

    public interface DataStatus{
        void DataIsLoaded(List<Hotel> hotels, List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }

    public FirebaseDatabaseHotel(){
        mDatabase = FirebaseDatabase.getInstance();
        mReferenceHotels =mDatabase.getReference("hotels");
    }
    public void readHotels(final FirebaseDatabaseHotel.DataStatus dataStatus){
        mReferenceHotels.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                hotels.clear();
                List<String> keys = new ArrayList<>();
                for (DataSnapshot keyNode : dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    Hotel hotel=keyNode.getValue(Hotel.class);
                    hotels.add(hotel);
                }
                dataStatus.DataIsLoaded(hotels,keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    public void addHotel(Hotel hotel,final DataStatus dataStatus){
        String key = mReferenceHotels.push().getKey();
        mReferenceHotels.child(key).setValue(hotel).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                dataStatus.DataIsInserted();
            }
        });
    }
    public void updateHotel(String key,Hotel hotel,final DataStatus dataStatus){
        mReferenceHotels.child(key).setValue(hotel).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                dataStatus.DataIsUpdated();
            }
        });
    }
    public void deleteHotel(String key,final DataStatus dataStatus){
        mReferenceHotels.child(key).setValue(null).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                dataStatus.DataIsDeleted();
            }
        });
    }
}
