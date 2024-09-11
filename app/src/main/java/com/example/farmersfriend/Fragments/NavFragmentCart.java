package com.example.farmersfriend.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farmersfriend.Activities.PlaceOrderActivity;
import com.example.farmersfriend.Adapters.CartAdapter;
import com.example.farmersfriend.DataModels.CartModel;
import com.example.farmersfriend.Database.DatabaseAgro;
import com.example.farmersfriend.R;
import com.example.farmersfriend.Utilities.OnIncreDecreAmountListner;
import com.example.farmersfriend.Utilities.Shared_Preference_manager;
import com.example.farmersfriend.Utilities.UtilityMethod;
import com.google.gson.Gson;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

public class NavFragmentCart extends Fragment implements OnIncreDecreAmountListner, View.OnClickListener {
    List<CartModel> cartList = new ArrayList<>();
    Context context;
    RecyclerView recyclerView;
    CartAdapter cartAdapter;
    private float totalAmount;
    private TextView txtTotalAmount;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context=context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.nav_fragment_cart,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.nav_Cartrecycler);
        txtTotalAmount=view.findViewById(R.id.txt_cart_total_amount);

        cartList = DatabaseAgro
                .getInstance(context)
                .getAppDatabase()
                .cartDAO()
                .getAllCart();
        cartAdapter =new CartAdapter(cartList,context);
        cartAdapter.setOnIncreDecreAmountListner(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(cartAdapter);

        txtTotalAmount.setOnClickListener(this);

        calculateAmount();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onIncrementAmount(float amount) {
        totalAmount+=amount;
        txtTotalAmount.setText("Place Order of "+context.getResources().getString(R.string.rs_Symbol)+" "+ UtilityMethod.convertFloatToString(totalAmount));
    }

    @Override
    public void onDecrementAmount(float amount) {
        totalAmount-=amount;
        txtTotalAmount.setText("Place Order of "+context.getResources().getString(R.string.rs_Symbol)+" "+ UtilityMethod.convertFloatToString(totalAmount));

    }

    private void calculateAmount()
    {
        for (CartModel cm:cartList)
        {
            totalAmount+=cm.getPrice();
        }
        txtTotalAmount.setText("Place Order of "+context.getResources().getString(R.string.rs_Symbol)+" "+ UtilityMethod.convertFloatToString(totalAmount));
    }

    @Override
    public void onClick(View v) {

        if (cartList.size()==0)
        {
            Toast.makeText(context, "Cart Is Empty", Toast.LENGTH_SHORT).show();
        }else
        {
            Gson gson=new Gson();
            String listString=gson.toJson(cartList);
            Intent intent = new Intent(context, PlaceOrderActivity.class);
            intent.putExtra("totalAmt",totalAmount);
            Shared_Preference_manager.setCartList(context,listString);
            context.startActivity(intent);
        }
    }
}
