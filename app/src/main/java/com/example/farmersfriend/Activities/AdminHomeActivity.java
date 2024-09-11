package com.example.farmersfriend.Activities;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.farmersfriend.Fragments.BookingFragment;
import com.example.farmersfriend.Fragments.EquipmentFragment;
import com.example.farmersfriend.Fragments.HomeFragment;
import com.example.farmersfriend.Fragments.ProductFragment;
import com.example.farmersfriend.Fragments.ProfileFragment;
import com.example.farmersfriend.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AdminHomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addbottomnavigation_layout);
        BottomNavigationView bottomNavigationView=findViewById(R.id.adbottomnav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        if (menuItem.getItemId()==R.id.adhome)
        {
            FragmentManager fragmentManager=getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragmentContainer,new HomeFragment());
            fragmentTransaction.commit();
        }

        if (menuItem.getItemId()==R.id.adproduct)
        {
            FragmentManager fragmentManager=getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragmentContainer,new ProductFragment());
            fragmentTransaction.commit();
        }
        if (menuItem.getItemId()==R.id.adequipment)
        {
            FragmentManager fragmentManager=getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragmentContainer,new EquipmentFragment()
            );
            fragmentTransaction.commit();
        }

        if (menuItem.getItemId()==R.id.adprofile)
        {
            FragmentManager fragmentManager=getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragmentContainer,new ProfileFragment());
            fragmentTransaction.commit();
        }

        if (menuItem.getItemId()==R.id.adbookings)
        {
            FragmentManager fm=getSupportFragmentManager();
            FragmentTransaction ft=fm.beginTransaction();
            ft.replace(R.id.fragmentContainer,new BookingFragment());
            ft.commit();
        }
        return true;
    }

}
