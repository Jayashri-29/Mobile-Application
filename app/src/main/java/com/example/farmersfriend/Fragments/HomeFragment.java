package com.example.farmersfriend.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farmersfriend.Adapters.HomeAdapter;
import com.example.farmersfriend.Adapters.OrderAdapter;
import com.example.farmersfriend.DataModels.HomeModel;
import com.example.farmersfriend.DataModels.OrderModel;
import com.example.farmersfriend.Database.DatabaseAgro;
import com.example.farmersfriend.R;
import com.example.farmersfriend.StaticData.CustomerOrder;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    /*List<HomeModel> EntryList;
    Context ctx;
    RecyclerView recyclerView;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.ctx = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_recycler_layout, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.homerecycler);
        EntryList = new ArrayList<>();
        EntryList = DatabaseAgro.getInstance(ctx).getAppDatabase()
                .homeDAO().getAllEntry();

        // OrderList.add(new CustomerOrder("Madhuri Patil","986575254","Cotton Seed","900"));
        //  OrderList.add(new CustomerOrder("Pooja Patil","9834354756","flower Seed","70"));
        //  OrderList.add(new CustomerOrder("Rutu Mahajan","742595254","Vegetable Seed","80"));
        //  OrderList.add(new CustomerOrder("Lalita Ingle","8888400478","Cotton Seed","900"));
        HomeAdapter homeAdapter = new HomeAdapter(EntryList, ctx);
        recyclerView.setLayoutManager(new LinearLayoutManager(ctx, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(homeAdapter);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}

    */
   List<OrderModel> OdList = new ArrayList<>();
    Context context;
    RecyclerView recyclerView;
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

}
