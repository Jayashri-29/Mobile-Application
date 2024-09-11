package com.example.farmersfriend.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farmersfriend.Adapters.BookingAdapter;
import com.example.farmersfriend.DataModels.BookingModel;
import com.example.farmersfriend.DataModels.EquipmentModel;
import com.example.farmersfriend.Database.DatabaseAgro;
import com.example.farmersfriend.R;

import java.util.ArrayList;
import java.util.List;

public class NavFragmentBooking extends Fragment {
    List<BookingModel> BkList=new ArrayList<>();
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
        return inflater.inflate(R.layout.nav_recycler_booking_layout,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView=view.findViewById(R.id.bookingRecycler);

        BkList= DatabaseAgro.getInstance(context)
                .getAppDatabase().bookingDAO().getAllBookigs();

       BookingAdapter bookingAdapter=new BookingAdapter(BkList,context);
        recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(bookingAdapter);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
