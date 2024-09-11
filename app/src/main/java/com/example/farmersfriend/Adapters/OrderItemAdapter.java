package com.example.farmersfriend.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farmersfriend.DataModels.OrderItemModel;
import com.example.farmersfriend.R;

import java.util.List;

public class OrderItemAdapter extends RecyclerView.Adapter<OrderItemAdapter.MyViewHolder>
{ ;
    List<OrderItemModel> orderItemModelList;
    Context context;


    public OrderItemAdapter(List<OrderItemModel> orderItemModelList, Context context) {
        this.orderItemModelList = orderItemModelList;
        this.context = context;
    }


    @NonNull
    @Override
    public OrderItemAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new OrderItemAdapter.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.orderitemlayout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull OrderItemAdapter.MyViewHolder holder, int position) {

        final OrderItemModel orderItemModel= orderItemModelList.get(position);

        holder.txtitemprize.setText("Rs."+ String.valueOf(orderItemModel.getAmount()));
        holder.txtitemname.setText(orderItemModel.getProductName());
        holder.txtitemquantity.setText("Qty "+ String.valueOf(orderItemModel.getQuantity()));

    }

    @Override
    public int getItemCount() {
        return orderItemModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {

        TextView txtitemname, txtitemquantity, txtitemprize;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txtitemname=itemView.findViewById(R.id.txtitemname);
            txtitemquantity=itemView.findViewById(R.id.txtitemquantity);
            txtitemprize=itemView.findViewById(R.id.txtitemprize);
        }
    }
}
