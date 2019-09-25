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

public class FirebaseDatabaseGuide {
    private FirebaseDatabase mDatabase;
    private DatabaseReference mRerenceGuides;
    private List<Guide> guides=new ArrayList<>();

    public interface DataStatus{
        void DataIsLoaded(List<Guide> guides, List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }

    public FirebaseDatabaseGuide() {
        mDatabase =FirebaseDatabase.getInstance();
        mRerenceGuides =mDatabase.getReference("guides");
    }
    public void readGuides(final DataStatus dataStatus){
        mRerenceGuides.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                guides.clear();
                List<String>keys = new ArrayList<>();
                for (DataSnapshot keyNode : dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    Guide guide=keyNode.getValue(Guide.class);
                    guides.add(guide);
                }
                dataStatus.DataIsLoaded(guides,keys);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    public void addGuide(Guide guide,final DataStatus dataStatus){
        String key = mRerenceGuides.push().getKey();
        mRerenceGuides.child(key).setValue(guide).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                dataStatus.DataIsInserted();
            }
        });
    }
    public void updateGuide(String key,Guide guide,final DataStatus dataStatus){
        mRerenceGuides.child(key).setValue(guide).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                dataStatus.DataIsUpdated();
            }
        });
    }
    public void deleteGuide(String key,final DataStatus dataStatus){
        mRerenceGuides.child(key).setValue(null).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                dataStatus.DataIsDeleted();
            }
        });
    }
}
