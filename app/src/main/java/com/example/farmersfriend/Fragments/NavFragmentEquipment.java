package com.example.farmersfriend.Fragments;

import android.Manifest;
import android.app.Activity;
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
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farmersfriend.Adapters.EquipmentsAdapters;
import com.example.farmersfriend.DataModels.EquipmentModel;
import com.example.farmersfriend.Database.DatabaseAgro;
import com.example.farmersfriend.R;
import com.example.farmersfriend.StaticData.CustomerOrder;
import com.example.farmersfriend.Utilities.Shared_Preference_manager;
import com.example.farmersfriend.Utilities.UtilityMethod;

import java.util.ArrayList;
import java.util.List;

public class NavFragmentEquipment extends Fragment implements View.OnClickListener {

    List<EquipmentModel> EquiList=new ArrayList<>();
    Context context;
    RecyclerView recyclerView;

    ImageView imageView;
    public static final int CAMERA_REQUEST=20;

    @Override
    public void onAttach(@NonNull Context context) {
        this.context=context;
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.nav_recycler_equipment_layout,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView=view.findViewById(R.id.NavRecyclerEquipment);
        EquiList= DatabaseAgro
                .getInstance(context)
                .getAppDatabase()
                .equipmentDAO()
                .getAllEquipment();

      //imageView.setImageBitmap(UtilityMethod.imgConvertFromByteArrayToBitmap(equipmentModel.getImageview())   );

        EquipmentsAdapters equipmentsAdapters =new EquipmentsAdapters(EquiList,context);
       recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(equipmentsAdapters);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onClick(View v) {


    }
}
