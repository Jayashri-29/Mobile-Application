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

import com.example.farmersfriend.Adapters.BookingAdapter;
import com.example.farmersfriend.DataModels.BookingModel;
import com.example.farmersfriend.Database.DatabaseAgro;
import com.example.farmersfriend.R;

import java.util.ArrayList;
import java.util.List;

public class BookingFragment extends Fragment {


    Context ctx;
    List<BookingModel> bokList;

    RecyclerView rv_booking;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.ctx=context;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.lay_frag_booking,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rv_booking=view.findViewById(R.id.rv_booking);
        bokList=new ArrayList<>();
        bokList= DatabaseAgro.getInstance(ctx).getAppDatabase()
                .bookingDAO().getAllBookigs();

        rv_booking.setLayoutManager(new LinearLayoutManager(ctx, LinearLayout.VERTICAL,false));
        rv_booking.setAdapter(new BookingAdapter(bokList,ctx));
    }


}
