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

public class RecyclerViewHotel_Config {

    private Context mContext;
    private HotelsAdapter mHotelsAdapter;

    public void setConfig(RecyclerView recyclerView, Context context, List<Hotel> hotels, List<String>keys){

        //    mAuth = FirebaseAuth.getInstance();
        //    user=mAuth.getCurrentUser();

        mContext= context;
        mHotelsAdapter = new HotelsAdapter(hotels,keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mHotelsAdapter);
    }

    class HotelItemView extends RecyclerView.ViewHolder{
        private TextView mHname;
        private TextView mHlocation;
        private TextView mHdetails;
        private TextView mHno;

        private String key;

        public  HotelItemView (ViewGroup parent) {
            super(LayoutInflater.from(mContext).inflate(R.layout.hotel_list_item, parent, false));

            mHname = (TextView) itemView.findViewById(R.id.hname_textView);
            mHlocation = (TextView) itemView.findViewById(R.id.hlocation_textView);
            mHdetails = (TextView) itemView.findViewById(R.id.hdetails_textView);
            mHno = (TextView) itemView.findViewById(R.id.hno_textView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    Intent intent = new Intent(mContext,HotelDetailsActivity.class);
                    intent.putExtra("key",key);
                    intent.putExtra("hname",mHname.getText().toString());
                    intent.putExtra("hlocation",mHlocation.getText().toString());
                    intent.putExtra("hdetails",mHdetails.getText().toString());
                    intent.putExtra("hno",mHno.getText().toString());

                    mContext.startActivity(intent);


                }
            });
        }
        public void bind(Hotel hotel, String key){
            mHname.setText(hotel.getHname());
            mHlocation.setText(hotel.getHlocation());
            mHdetails.setText(hotel.getHdetails());
            mHno.setText(hotel.getHno());
            this.key = key;
        }
    }
    class HotelsAdapter extends RecyclerView.Adapter<HotelItemView> {
        private List<Hotel> mHotelList;
        private List<String> mkeys;

        public HotelsAdapter(List<Hotel> mHotelList, List<String> mkeys) {
            this.mHotelList = mHotelList;
            this.mkeys = mkeys;
        }

        @NonNull
        @Override
        public HotelItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new HotelItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull HotelItemView holder, int position) {
            holder.bind(mHotelList.get(position), mkeys.get(position));

        }

        @Override
        public int getItemCount() {
            return mHotelList.size();
        }
    }
}

