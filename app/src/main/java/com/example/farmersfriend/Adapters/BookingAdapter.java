package com.example.farmersfriend.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farmersfriend.DataModels.BookingModel;
import com.example.farmersfriend.DataModels.EquipmentModel;
import com.example.farmersfriend.R;
import com.example.farmersfriend.Utilities.UtilityMethod;

import java.util.ArrayList;
import java.util.List;

public class BookingAdapter extends RecyclerView.Adapter<BookingAdapter.BookingViewHolder>{
    List<BookingModel> BookingList;
    Context context;

    public BookingAdapter(List<BookingModel> bookingList, Context context) {
        BookingList = bookingList;
        this.context = context;
    }

    @NonNull
    @Override
    public BookingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BookingViewHolder(LayoutInflater.from(context).inflate(R.layout.booking_item_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull BookingViewHolder holder, int position) {
           BookingModel model=BookingList.get(position);
           holder.name.setText(model.getEqpName());
           holder.rent.setText(UtilityMethod.convertFloatToString(model.getEqpRent()));
           holder.txtBookFrToDate.setText(model.getFrDate()+ " To "+model.getToDate());
    }

    @NonNull
    public int getItemCount() {
        return BookingList.size();
    }

    public class BookingViewHolder extends RecyclerView.ViewHolder{
        TextView name ,rent,txtBookFrToDate ;
        public BookingViewHolder(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.txtBookName);
            rent=itemView.findViewById(R.id.txtBookRent1);
            txtBookFrToDate=itemView.findViewById(R.id.txtBookFrToDate);

        }
    }
}
