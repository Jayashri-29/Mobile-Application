package com.example.farmersfriend.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farmersfriend.DAO.HomeDAO;
import com.example.farmersfriend.DataModels.HomeModel;
import com.example.farmersfriend.R;
import com.example.farmersfriend.StaticData.CustomerOrder;
import com.example.farmersfriend.Utilities.UtilityMethod;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.itemViewHolder> {
    List<HomeModel> EntryList;
    Context context;
    public HomeAdapter(List<HomeModel> entryList, Context context) {
        EntryList = entryList;
        this.context = context;

    }
    @NonNull
    @Override
    public itemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.home_item_layout,parent,false);
        return new itemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull itemViewHolder holder, int position) {
        HomeModel homeModel = EntryList.get(position);
        holder.customername.setText(homeModel.getName());
        holder.mono.setText(homeModel.getContact());
        holder.productname.setText(homeModel.getProName());
        holder.productprice.setText(UtilityMethod.convertFloatToString(homeModel.getProPrice()));
    }

    @Override
    public int getItemCount() {
        return EntryList.size();
    }

    public class itemViewHolder extends RecyclerView.ViewHolder{
        TextView customername,mono,productname,productprice;
        public itemViewHolder(@NonNull View itemView) {
            super(itemView);
            customername=itemView.findViewById(R.id.customername);
            mono=itemView.findViewById(R.id.mono);
            productname=itemView.findViewById(R.id.productname);
            productprice=itemView.findViewById(R.id.productprice);
        }
    }

}
