package com.example.farmersfriend.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.farmersfriend.R;
import com.example.farmersfriend.Utilities.Shared_Preference_manager;

public class NavFragmentProfile extends Fragment {
    TextView txtName,txtEmail,txtContact;
    Context context;
    @Override
    public void onAttach(@NonNull Context context)
    {
        super.onAttach(context);
        this.context=context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.nav_fragment_profile,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtName = view.findViewById(R.id.txtName);
        txtEmail = view.findViewById(R.id.txtemail);
        txtContact= view.findViewById(R.id.txtcontact);
        txtName.setText(Shared_Preference_manager.getUser_Name(context));
        txtEmail.setText(Shared_Preference_manager.getEmail(context));
        txtContact.setText(Shared_Preference_manager.getUser_Mobile(context));

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
