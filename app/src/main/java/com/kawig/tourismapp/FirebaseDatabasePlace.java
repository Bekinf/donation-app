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

public class FirebaseDatabasePlace {
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferencePlaces;
    private List<Place> places = new ArrayList<>();

    public interface DataStatus{
        void DataIsLoaded(List<Place> places, List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }

    public FirebaseDatabasePlace() {
        mDatabase = FirebaseDatabase.getInstance();
        mReferencePlaces = mDatabase.getReference("places");
    }
    public void readPlace(final DataStatus dataStatus){
        mReferencePlaces.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                places.clear();
                List<String> keys =new ArrayList<>();
                for (DataSnapshot keyNode : dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    Place place = keyNode.getValue(Place.class);
                    places.add(place);
                }
                dataStatus.DataIsLoaded(places,keys);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    public void addPlace(Place place,final DataStatus dataStatus){
        String key = mReferencePlaces.push().getKey();
        mReferencePlaces.child(key).setValue(place).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                dataStatus.DataIsInserted();
            }
        });
    }
    public void updatePlace(String key,Place place,final DataStatus dataStatus){
        mReferencePlaces.child(key).setValue(place).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                dataStatus.DataIsUpdated();
            }
        });
    }
    public void deletePlace(String key,final DataStatus dataStatus){
        mReferencePlaces.child(key).setValue(null).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                dataStatus.DataIsDeleted();
            }
        });
    }
}
