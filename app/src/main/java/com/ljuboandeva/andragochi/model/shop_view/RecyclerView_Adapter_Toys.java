package com.ljuboandeva.andragochi.model.shop_view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.ljuboandeva.andragochi.R;
import com.ljuboandeva.andragochi.model.shop.Toy;

import java.util.ArrayList;

public class RecyclerView_Adapter_Toys extends
        RecyclerView.Adapter<FoodViewHolder> {
    private ArrayList<Toy> arrayList;
    private Context context;


    public RecyclerView_Adapter_Toys(Context context, ArrayList<Toy> arrayList) {
        this.context = context;
        this.arrayList = arrayList;

    }


    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);

    }

    @Override
    public void onBindViewHolder(FoodViewHolder holder, int position) {

        final FoodViewHolder mainHolder = holder;
//        mainHolder.title.setText();
//        mainHolder.price.setText();

    }

    @Override
    public FoodViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(viewGroup.getContext());

        ViewGroup mainGroup = (ViewGroup) mInflater.inflate(R.layout.item_toy_shop, viewGroup, false);
        FoodViewHolder mainHolder = new FoodViewHolder(mainGroup) {
            @Override
            public String toString() {
                return super.toString();
            }
        };


        return mainHolder;

    }


}