package com.kawig.tourismapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewPlace_Config {

    private Context mContext;
    private PlacesAdapter mPlacesAdapter;

    public void setConfig(RecyclerView recyclerView, Context context, List<Place> places, List<String>keys){

        mContext= context;
        mPlacesAdapter = new PlacesAdapter(places,keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mPlacesAdapter);
    }
    class PlaceItemView extends RecyclerView.ViewHolder {
        private TextView mPname;
        private TextView mPlocation;
        private TextView mPdetails;
        private TextView mPno;

        private String key;

        public PlaceItemView(ViewGroup parent) {
            super(LayoutInflater.from(mContext).inflate(R.layout.place_list_item, parent, false));

            mPname = (TextView) itemView.findViewById(R.id.pname_textView);
            mPlocation = (TextView) itemView.findViewById(R.id.ploc_textView);
            mPdetails = (TextView) itemView.findViewById(R.id.pdet_textView);
            mPno = (TextView) itemView.findViewById(R.id.pno_textView);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    Intent intent = new Intent(mContext,GuideDetailsActivity.class);
                    intent.putExtra("key",key);
                    intent.putExtra("pname",mPname.getText().toString());
                    intent.putExtra("plocation",mPlocation.getText().toString());
                    intent.putExtra("pdetails",mPdetails.getText().toString());
                    intent.putExtra("pno",mPno.getText().toString());

                    mContext.startActivity(intent);


                }
            });
        }

        public void bind(Place place, String key) {
            mPname.setText(place.getPname());
            mPlocation.setText(place.getPloc());
            mPdetails.setText(place.getPdet());
            mPno.setText(place.getPno());
            this.key = key;
        }
    }

    class PlacesAdapter extends RecyclerView.Adapter<PlaceItemView> {
        private List<Place> mPlaceList;
        private List<String> mkeys;

        public PlacesAdapter(List<Place> mPlaceList, List<String> mkeys) {
            this.mPlaceList = mPlaceList;
            this.mkeys = mkeys;
        }

        @NonNull
        @Override
        public PlaceItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new PlaceItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull PlaceItemView holder, int position) {
            holder.bind(mPlaceList.get(position), mkeys.get(position));
        }

        @Override
        public int getItemCount() {
            return mPlaceList.size();
        }
    }
}

