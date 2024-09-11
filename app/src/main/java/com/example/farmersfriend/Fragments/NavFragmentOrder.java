package com.example.farmersfriend.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farmersfriend.Activities.LoginActivity;
import com.example.farmersfriend.Activities.ShowOrderActivity;
import com.example.farmersfriend.Adapters.BookingAdapter;
import com.example.farmersfriend.Adapters.OrderAdapter;
import com.example.farmersfriend.DataModels.OrderModel;
import com.example.farmersfriend.DataModels.ProductModel;
import com.example.farmersfriend.Database.DatabaseAgro;
import com.example.farmersfriend.R;

import java.util.ArrayList;
import java.util.List;

public class NavFragmentOrder extends Fragment  {

    List<OrderModel> OdList = new ArrayList<>();
    Context context;
    RecyclerView recyclerView;
   private Button btnDetails;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context=context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.nav_fragment_order,container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView=view.findViewById(R.id.nav_orderRecycler);
        btnDetails=view.findViewById(R.id.btnDetails);
       // btnDetails.setOnClickListener(this);

        /*OdList.add(new ProductModel(R.drawable.tomatoseed,201,"Hybrid Tomato Seeds","Brand : Shine Brand Seed","1/1/2019","12/12/2021","Rs 1,150"));
        OdList.add(new ProductModel(R.drawable.tomatoseed,201,"Hybrid Tomato Seeds","Brand : Shine Brand Seed","1/1/2019","12/12/2021","Rs 1,150"));
        OdList.add(new ProductModel(R.drawable.tomatoseed,201,"Hybrid Tomato Seeds","Brand : Shine Brand Seed","1/1/2019","12/12/2021","Rs 1,150"));
        OdList.add(new ProductModel(R.drawable.tomatoseed,201,"Hybrid Tomato Seeds","Brand : Shine Brand Seed","1/1/2019","12/12/2021","Rs 1,150"));
        OdList.add(new ProductModel(R.drawable.tomatoseed,201,"Hybrid Tomato Seeds","Brand : Shine Brand Seed","1/1/2019","12/12/2021","Rs 1,150"));*/

        OdList= DatabaseAgro.getInstance(context)
                .getAppDatabase().orderDAO().getAllOrders();


        OrderAdapter orderAdapter=new OrderAdapter(OdList,context);
        recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(orderAdapter);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

   /* @Override
    public void onClick(View v) {
        if (btnDetails.getId()==v.getId()) {
            Intent intent = new Intent(context, ShowOrderActivity.class);
            context.startActivity(intent);
        }
    }

    */
}
