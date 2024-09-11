package com.example.farmersfriend.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farmersfriend.Adapters.ProductAdapter;
import com.example.farmersfriend.DataModels.EquipmentModel;
import com.example.farmersfriend.DataModels.ProductModel;
import com.example.farmersfriend.Database.DatabaseAgro;
import com.example.farmersfriend.R;
import com.example.farmersfriend.Utilities.Shared_Preference_manager;

import java.util.ArrayList;
import java.util.List;

public class NavFragmentProduct extends Fragment implements View.OnClickListener {
    List<ProductModel> ProList=new ArrayList<>();
    Context context;
    public static final int CAMERA_REQUEST=20;
    TextView PName,PBrand,PMfDate,PExDate,Pprice;
    Button Add;
    ImageView imageView;
    RecyclerView recyclerView;
    @Override
    public void onAttach(@NonNull Context context) {
        this.context=context;
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.nav_recycler_product_layout,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView=view.findViewById(R.id.NavRecyclerProduct);


        ProList = DatabaseAgro.getInstance(context)
                .getAppDatabase()
                .productDAO()
                .getAllProduct();

        ProductAdapter productAdapter=new ProductAdapter(ProList,context);
        recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(productAdapter);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onClick(View v) {

    }
}
