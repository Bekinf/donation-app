package com.kawig.tourismapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserRecyclerViewCar_Config {
    private Context mContext;

    private UserRecyclerViewCar_Config.CarsAdapter mCarsAdapter;

    public void setConfig(RecyclerView recyclerView, Context context, List<Car> cars, List<String>keys){

        mContext= context;
        mCarsAdapter = new UserRecyclerViewCar_Config.CarsAdapter(cars,keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mCarsAdapter);
    }

    class CarItemView extends RecyclerView.ViewHolder {

        private TextView mCtype;
        private TextView mCnum;
        private TextView mCno;
        private TextView mCfaci;

        private String key;

        public CarItemView(ViewGroup parent) {
            super(LayoutInflater.from(mContext).inflate(R.layout.car_list_item, parent, false));

            mCtype = (TextView) itemView.findViewById(R.id.ctype_txtView);
            mCnum = (TextView) itemView.findViewById(R.id.cnum_txtView);
            mCno = (TextView) itemView.findViewById(R.id.cno_txtView);
            mCfaci = (TextView) itemView.findViewById(R.id.cfaci_txtView);


        }

        public void bind(Car car, String key) {
            mCtype.setText(car.getCtype());
            mCnum.setText(car.getCnumber());
            mCno.setText(car.getCno());
            mCfaci.setText(car.getCfaci());

            this.key = key;
        }

    }

    class CarsAdapter extends RecyclerView.Adapter<CarItemView> {
        private List<Car> mCarList;
        private List<String> mkeys;

        public CarsAdapter(List<Car> mCarList, List<String> mkeys) {
            this.mCarList = mCarList;
            this.mkeys = mkeys;
        }

        public CarsAdapter() {
            super();
        }

        @NonNull
        @Override
        public CarItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new CarItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull CarItemView holder, int position) {
            holder.bind(mCarList.get(position),mkeys.get(position));

        }

        @Override
        public int getItemCount() {
            return mCarList.size();
        }
    }
}
