package com.example.farmersfriend.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farmersfriend.DataModels.CartModel;
import com.example.farmersfriend.DataModels.ProductModel;
import com.example.farmersfriend.Database.DatabaseAgro;
import com.example.farmersfriend.R;
import com.example.farmersfriend.Utilities.UtilityMethod;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    List<ProductModel> ProductList;
    Context context;
    public ProductAdapter(List<ProductModel> ProList, Context context){
        this.ProductList = ProList;
        this.context = context;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProductViewHolder(LayoutInflater.from(context).inflate(R.layout.product_item_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, final int position) {
        final ProductModel productModel = ProductList.get(position);
        holder.nav_proId.setId(productModel.getNav_proId());
        holder.nav_protxt_name.setText(productModel.getNav_protxt_name());
        holder.nav_protxt_brand.setText(productModel.getNav_protxt_brand());
        holder.nav_protxt_mfDate.setText(productModel.getNav_protxt_mfDate());
        holder.nav_protxt_ExDate.setText(productModel.getNav_protxt_ExDate());
        holder.nav_protxt_price.setText(UtilityMethod.convertFloatToString(productModel.getNav_protxt_price()));
        holder.imageView.setImageBitmap(UtilityMethod.imgConvertFromByteArrayToBitmap(productModel.getProimageview()));

        holder.btn_proAddCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CartModel cartModel=new CartModel();
                cartModel.setName(productModel.getNav_protxt_name());
                cartModel.setPrice(productModel.getNav_protxt_price());
                cartModel.setQuantity(1);
                cartModel.setImageview(productModel.getProimageview());
                DatabaseAgro.getInstance(context)
                        .getAppDatabase().cartDAO()
                        .insertCartModel(cartModel);
                Toast.makeText(context, "Added To Cart", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public int getItemCount() {
        return ProductList.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        CardView cardView;
        TextView nav_proId ,nav_protxt_name ,nav_protxt_brand ,nav_protxt_mfDate,nav_protxt_ExDate,nav_protxt_price;
        Button btn_proAddCart;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            nav_proId=itemView.findViewById(R.id.nav_proId);
            nav_protxt_name=itemView.findViewById(R.id.nav_protxt_name);
            nav_protxt_brand=itemView.findViewById(R.id.nav_protxt_brand);
            nav_protxt_mfDate=itemView.findViewById(R.id.nav_protxt_mfDate);
            nav_protxt_ExDate=itemView.findViewById(R.id.nav_protxt_ExDate);
            nav_protxt_price=itemView.findViewById(R.id.nav_protxt_price);
            imageView=itemView.findViewById(R.id.nav_pro_img);
            cardView=itemView.findViewById(R.id.cardview);
            btn_proAddCart=itemView.findViewById(R.id.btn_proAddCart);
        }
    }
}
