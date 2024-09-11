package com.example.farmersfriend.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farmersfriend.DataModels.CartModel;
import com.example.farmersfriend.Database.DatabaseAgro;
import com.example.farmersfriend.R;
import com.example.farmersfriend.Utilities.OnIncreDecreAmountListner;
import com.example.farmersfriend.Utilities.UtilityMethod;

import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder>{
    List<CartModel> CartList;
    Context context;
    private OnIncreDecreAmountListner onInDeAmountListner;

    public CartAdapter (List<CartModel> cartList, Context context){
        this.CartList = cartList;
        this.context = context;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CartAdapter.CartViewHolder(LayoutInflater.from(context).inflate(R.layout.cart_item_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull final CartViewHolder holder, int position) {
        final CartModel cartModel = CartList.get(position);
        holder.imageView.setImageBitmap(UtilityMethod.imgConvertFromByteArrayToBitmap(cartModel.getImageview()));
        holder.txtCartName.setText(cartModel.getName());
        holder.txtCartQty.setText(UtilityMethod.convertIntToString(cartModel.getQuantity()));
        holder.txtCartPrice.setText(UtilityMethod.convertFloatToString(cartModel.getPrice()));
        final float originalPrize=cartModel.getPrice();

        holder.imgIncre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int newQty= UtilityMethod.convertStringToInt(holder.txtCartQty.getText().toString())+1;
                float newPrize=originalPrize*newQty;

                holder.txtCartName.setText(context.getResources().getString(R.string.rs_Symbol)+" "+UtilityMethod.convertFloatToString(newPrize));
                holder.txtCartQty.setText(UtilityMethod.convertIntToString(newQty));


                onInDeAmountListner.onIncrementAmount(originalPrize);
                cartModel.setPrice(newPrize);
                cartModel.setQuantity(newQty);

            }
        });

        holder.imgDecre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int newQty= UtilityMethod.convertStringToInt(holder.txtCartQty.getText().toString())-1;
                float newPrize=originalPrize*newQty;

                holder.txtCartName.setText(context.getResources().getString(R.string.rs_Symbol)+" "+UtilityMethod.convertFloatToString(newPrize));
                holder.txtCartQty.setText(UtilityMethod.convertIntToString(newQty));

                onInDeAmountListner.onDecrementAmount(originalPrize);

                cartModel.setPrice(newPrize);
                cartModel.setQuantity(newQty);
            }
        });
        holder.Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(context);
                builder.setMessage("Are you sure you want to remove this product?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int id) {
                                CartModel cartModel=CartList.get(holder.getAdapterPosition());
                                DatabaseAgro.getInstance(context)
                                        .getAppDatabase().cartDAO().deleteCartModel(cartModel);
                                //notify when data is deleted
                                int position = holder.getAdapterPosition();
                                CartList.remove(position);
                                notifyItemRemoved(position);
                                notifyItemRangeChanged(position,CartList.size());
                                Toast.makeText(context, "Product removed", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //  Action for 'NO' Button
                                dialog.cancel();
                            }
                        });
                AlertDialog alertDialog=builder.create();
                alertDialog.show();
            }
        });



    }

    public int getItemCount() { return CartList.size(); }

    public class CartViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView,imgIncre,imgDecre,Delete;
        TextView txtCartName, txtCartQty, txtCartPrice;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img_cart_list_item);
            txtCartName = itemView.findViewById(R.id.txtPName_cart_list_item);
            txtCartQty = itemView.findViewById(R.id.txt_cart_qty);
            txtCartPrice = itemView.findViewById(R.id.txtPPrize_cart_list_item);
            Delete = itemView.findViewById(R.id.delete);


            imgIncre = itemView.findViewById(R.id.img_qty_increment);
            imgDecre= itemView.findViewById(R.id.img_qty_decrement);

        }
    }

    public void setOnIncreDecreAmountListner(OnIncreDecreAmountListner onIncreDecreAmountListner)
    {
        this.onInDeAmountListner=onIncreDecreAmountListner;
    }


}
