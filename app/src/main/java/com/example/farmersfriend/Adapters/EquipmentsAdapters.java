package com.example.farmersfriend.Adapters;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farmersfriend.DataModels.BookingModel;
import com.example.farmersfriend.DataModels.CartModel;
import com.example.farmersfriend.DataModels.EquipmentModel;
import com.example.farmersfriend.Database.DatabaseAgro;
import com.example.farmersfriend.R;
import com.example.farmersfriend.Utilities.Shared_Preference_manager;
import com.example.farmersfriend.Utilities.UtilityMethod;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class EquipmentsAdapters extends RecyclerView.Adapter<EquipmentsAdapters.EquipmentViewHolder> {

    List<EquipmentModel> EquipmentList;
    Context context;
    public EquipmentsAdapters(List<EquipmentModel> EquiList, Context context) {
        this.EquipmentList = EquiList;
        this.context = context;

    }

    @NonNull
    @Override
    public EquipmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
return new EquipmentViewHolder(LayoutInflater.from(context).inflate(R.layout.euipment_item_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull EquipmentViewHolder holder, int position) {

        final EquipmentModel equipmentModel = EquipmentList.get(position);
        holder.nav_equiId.setId(equipmentModel.getNav_equiId());
        holder.nav_equitext_name.setText(equipmentModel.getNav_equitext_name());
        holder.nav_equitext_brand.setText(equipmentModel.getNav_equitext_brand());
        holder.nav_equitext_Rent.setText(UtilityMethod.convertFloatToString(equipmentModel.getNav_equitext_Rent()));
        holder.nav_equitext_price.setText(UtilityMethod.convertFloatToString(equipmentModel.getNav_equitext_price()));
        holder.nav_equi_img.setImageBitmap(UtilityMethod.imgConvertFromByteArrayToBitmap(equipmentModel.getImageview()));


        holder.btn_equiAddCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CartModel cartModel=new CartModel();
                cartModel.setImageview(equipmentModel.getImageview());
                cartModel.setQuantity(1);
                cartModel.setName(equipmentModel.getNav_equitext_name());
                cartModel.setPrice(equipmentModel.getNav_equitext_price());
                DatabaseAgro.getInstance(context)
                        .getAppDatabase().cartDAO()
                        .insertCartModel(cartModel);

                Toast.makeText(context, "Added To Cart", Toast.LENGTH_SHORT).show();
            }
        });

        holder.btnEqpBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view=LayoutInflater.from(context).inflate(R.layout.lay_book_room,null,false);
                final TextView txtFrDate=view.findViewById(R.id.txtFrDate);
                final TextView txtToDate=view.findViewById(R.id.txtToDate);


                AlertDialog.Builder builder=new AlertDialog.Builder(context);

                builder.setView(view);

                builder.setPositiveButton("Book", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        BookingModel bookingModel=new BookingModel();
                        bookingModel.setEqpName(equipmentModel.getNav_equitext_name());
                        bookingModel.setFrDate(txtFrDate.getText().toString());
                        bookingModel.setToDate(txtToDate.getText().toString());
                        bookingModel.setEqpRent(equipmentModel.getNav_equitext_Rent());
                        //bookingModel.setCustName(Shared_Preference_manager.getUser_Name(context));

                        DatabaseAgro.getInstance(context)
                                .getAppDatabase().
                                bookingDAO()
                                .insertBookingModel(bookingModel);
                        Toast.makeText(context, "Booking Successful", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });

                AlertDialog alertDialog=builder.create();

                alertDialog.show();

                final Calendar cal=Calendar.getInstance();

                txtFrDate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DatePickerDialog datePickerDialog=new DatePickerDialog(context,
                                new DatePickerDialog.OnDateSetListener() {
                                    @Override
                                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                        String frDate=String.valueOf(dayOfMonth)+"/"+String.valueOf(month)+"/"+String.valueOf(year);
                                        txtFrDate.setText(frDate);
                                    }
                                },cal.get(Calendar.YEAR)
                                ,cal.get(Calendar.MONTH)
                                ,cal.get(Calendar.DAY_OF_MONTH));
                        datePickerDialog.show();
                    }
                });

                txtToDate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DatePickerDialog datePickerDialog=new DatePickerDialog(context,
                                new DatePickerDialog.OnDateSetListener() {
                                    @Override
                                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                        String toDate=String.valueOf(dayOfMonth)+"/"+String.valueOf(month)+"/"+String.valueOf(year);
                                        txtToDate.setText(toDate);
                                    }
                                },cal.get(Calendar.YEAR)
                                ,cal.get(Calendar.MONTH)
                                ,cal.get(Calendar.DAY_OF_MONTH));

                        datePickerDialog.show();
                    }
                });
            }
        });
    }

    public int getItemCount() {
        return EquipmentList.size();
    }

    public class EquipmentViewHolder extends RecyclerView.ViewHolder{
        ImageView nav_equi_img;
        CardView cardView;
        TextView nav_equiId ,nav_equitext_name ,nav_equitext_brand ,nav_equitext_Rent,nav_equitext_price;
        Button btn_equiAddCart,btnEqpBook;
        public EquipmentViewHolder(@NonNull View itemView) {
            super(itemView);
            nav_equiId=itemView.findViewById(R.id.nav_equiId);
            nav_equitext_name=itemView.findViewById(R.id.nav_equitext_name);
            nav_equitext_brand=itemView.findViewById(R.id.nav_equitext_brand);
            nav_equitext_Rent=itemView.findViewById(R.id.nav_equitext_Rent);
            nav_equitext_price=itemView.findViewById(R.id.nav_equitext_price);
            nav_equi_img=itemView.findViewById(R.id.nav_equi_img);
            cardView=itemView.findViewById(R.id.cardview);
            btn_equiAddCart=itemView.findViewById(R.id.btn_equiAddCart);
            btnEqpBook=itemView.findViewById(R.id.btn_equiBooking);
        }
    }
}
