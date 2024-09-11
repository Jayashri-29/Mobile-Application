package com.example.farmersfriend.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farmersfriend.Activities.ShowOrderActivity;
import com.example.farmersfriend.DataModels.OrderModel;
import com.example.farmersfriend.DataModels.ProductModel;
import com.example.farmersfriend.R;
import com.example.farmersfriend.Utilities.UtilityMethod;

import java.util.ArrayList;
import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {
    List<OrderModel> OrderList;
    Context context;

    public OrderAdapter(List<OrderModel> orderList, Context context) {
        OrderList = orderList;
        this.context = context;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new OrderViewHolder(LayoutInflater.from(context).inflate(R.layout.order_item_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        final OrderModel orderModel=OrderList.get(position);

        holder.name.setText(orderModel.getOrderdate());
        holder.rent.setText("Total :"+UtilityMethod.convertFloatToString(orderModel.getAmount()));

        holder.btnViewDetais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId()==R.id.btnDetails) {
                    Intent intent = new Intent(context, ShowOrderActivity.class);
                    intent.putExtra("order",orderModel);
                    context.startActivity(intent);

                }
            }
        });
    }

    @NonNull

    public int getItemCount() {
        return OrderList.size();
    }

    public class OrderViewHolder extends RecyclerView.ViewHolder{
        TextView name ,rent ;
        Button btnViewDetais;
        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.txtOrderName);
            rent=itemView.findViewById(R.id.txtOrderPrice);
            btnViewDetais=itemView.findViewById(R.id.btnDetails);

        }
    }
}
