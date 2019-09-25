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

public class RecyclerViewGuide_Config {

    private Context mContext;
    private GuidesAdapter mGuidesAdapter;
    public void setConfig(RecyclerView recyclerView, Context context, List<Guide> guides, List<String>keys){

        mContext= context;
        mGuidesAdapter = new GuidesAdapter(guides,keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mGuidesAdapter);
    }

    class GuideItemView extends RecyclerView.ViewHolder{
        private TextView mGname;
        private TextView mGaddress;
        private TextView mGlanguage;
        private TextView mGcity;
        private TextView mGno;

        private String key;

        public  GuideItemView (ViewGroup parent) {
            super(LayoutInflater.from(mContext).inflate(R.layout.guide_list_item, parent, false));

            mGname = (TextView) itemView.findViewById(R.id.gname_txtView);
            mGaddress = (TextView) itemView.findViewById(R.id.gaddress_txtView);
            mGlanguage = (TextView) itemView.findViewById(R.id.glanguage_txtView);
            mGcity = (TextView) itemView.findViewById(R.id.gcity_txtView);
            mGno = (TextView) itemView.findViewById(R.id.gno_txtView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                        Intent intent = new Intent(mContext,GuideDetailsActivity.class);
                        intent.putExtra("key",key);
                        intent.putExtra("gname",mGname.getText().toString());
                        intent.putExtra("gaddress",mGaddress.getText().toString());
                        intent.putExtra("glanguage",mGlanguage.getText().toString());
                        intent.putExtra("gcity",mGcity.getText().toString());
                        intent.putExtra("gno",mGno.getText().toString());

                        mContext.startActivity(intent);


                }
            });
        }

        public void bind(Guide guide, String key){
            mGname.setText(guide.getGname());
            mGaddress.setText(guide.getGaddress());
            mGlanguage.setText(guide.getGlanguage());
            mGcity.setText(guide.getGcity());
            mGno.setText(guide.getGno());
            this.key = key;
        }
    }
    class GuidesAdapter extends RecyclerView.Adapter<GuideItemView> {
        private List<Guide> mGuideList;
        private List<String> mkeys;

        public GuidesAdapter(List<Guide> mGuideList, List<String> mkeys) {
            this.mGuideList = mGuideList;
            this.mkeys = mkeys;
        }

        @NonNull
        @Override
        public GuideItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new GuideItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull GuideItemView holder, int position) {
            holder.bind(mGuideList.get(position), mkeys.get(position));
        }

        @Override
        public int getItemCount() {
            return mGuideList.size();
        }
    }

}
