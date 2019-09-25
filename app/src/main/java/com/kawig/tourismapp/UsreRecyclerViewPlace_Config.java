package com.kawig.tourismapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UsreRecyclerViewPlace_Config {
    private Context mContext;
    private PlaceAdapter mPlaceAdapter;
    public void setConfig(RecyclerView recyclerView, Context context, List<Place> places, List<String>keys){
        mContext = context;
        mPlaceAdapter = new PlaceAdapter(places,keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mPlaceAdapter);
    }
    class PlaceItemView extends RecyclerView.ViewHolder{
        private TextView mPname;
        private TextView mPdet;
         private TextView mPloc;
        private TextView mPno;

        private String key;

        public PlaceItemView(ViewGroup parent){
            super(LayoutInflater.from(mContext).inflate(R.layout.place_list_item,parent,false));

            mPname = (TextView)itemView.findViewById(R.id.pname_textView);
            mPdet = (TextView)itemView.findViewById(R.id.pdet_textView);
            mPloc = (TextView)itemView.findViewById(R.id.ploc_textView);
            mPno = (TextView)itemView.findViewById(R.id.pno_textView);

        }
        public void bind(Place place, String key){
            mPname.setText(place.getPname());
            mPdet.setText(place.getPdet());
            mPloc.setText(place.getPloc());
            mPno.setText(place.getPno());
            this.key = key;
        }
    }
    class PlaceAdapter extends RecyclerView.Adapter<PlaceItemView>{
        private List<Place> mPlaceList;
        private List<String> mkeys;

        public PlaceAdapter(List<Place> mPlaceList, List<String> mkeys) {
            this.mPlaceList = mPlaceList;
            this.mkeys = mkeys;
        }

        public PlaceAdapter() {
            super();
        }

        @NonNull
        @Override
        public PlaceItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new PlaceItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull PlaceItemView holder, int position) {
            holder.bind(mPlaceList.get(position),mkeys.get(position));
        }

        @Override
        public int getItemCount() {
            return mPlaceList.size();
        }
    }
}


