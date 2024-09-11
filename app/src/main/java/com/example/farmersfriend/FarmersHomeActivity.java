package com.example.farmersfriend;

import android.os.Bundle;

import com.example.farmersfriend.Fragments.HomeFragment;
import com.example.farmersfriend.Fragments.NavFragmentBooking;
import com.example.farmersfriend.Fragments.NavFragmentCart;
import com.example.farmersfriend.Fragments.NavFragmentEquipment;
import com.example.farmersfriend.Fragments.NavFragmentOrder;
import com.example.farmersfriend.Fragments.NavFragmentProduct;
import com.example.farmersfriend.Fragments.NavFragmentProfile;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.Toast;

public class FarmersHomeActivity extends AppCompatActivity {
    private  NavigationView navigationView;
    private DrawerLayout drawer;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmers_home);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer=(DrawerLayout)findViewById(R.id.drawer_layout);
        navigationView=(NavigationView)findViewById(R.id.nav_view);
        setUpNavigationView();
    }

    private void setUpNavigationView() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_Equipmengt:
                        FragmentManager fragmentManager1=getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction1=fragmentManager1.beginTransaction();
                        fragmentTransaction1.replace(R.id.nav_host_fragment,new NavFragmentEquipment());
                        fragmentTransaction1.commit();
                        break;

                   case R.id.nav_products:
                        FragmentManager fragmentManager=getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.nav_host_fragment,new NavFragmentProduct());
                        fragmentTransaction.commit();
                        break;

                    case R.id.nav_orders:
                        FragmentManager fragmentManager2=getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction2=fragmentManager2.beginTransaction();
                        fragmentTransaction2.replace(R.id.nav_host_fragment,new NavFragmentOrder());
                        fragmentTransaction2.commit();
                        break;
                    case R.id.nav_booking:
                        FragmentManager fragmentManager3=getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction3=fragmentManager3.beginTransaction();
                        fragmentTransaction3.replace(R.id.nav_host_fragment,new NavFragmentBooking());
                        fragmentTransaction3.commit();
                        break;
                    case R.id.nav_cart:
                        FragmentManager fragmentManager4=getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction4=fragmentManager4.beginTransaction();
                        fragmentTransaction4.replace(R.id.nav_host_fragment,new NavFragmentCart());
                        fragmentTransaction4.commit();
                        break;
                    case R.id.profile:
                        FragmentManager fragmentmanager=getSupportFragmentManager();
                        FragmentTransaction fragmenttransaction=fragmentmanager.beginTransaction();
                        fragmenttransaction.replace(R.id.nav_host_fragment,new NavFragmentProfile());
                        fragmenttransaction.commit();
                        break;


                }

                if (menuItem.isChecked()){
                    menuItem.setChecked(false);
                }
                else {menuItem.setChecked(true);}
                menuItem.setChecked(true);
                drawer.closeDrawers();
                return true;
            }
        });
        ActionBarDrawerToggle actionBarDrawerToggle= new
                ActionBarDrawerToggle(this,drawer,R.string.openDrawer,R.string.closeDrawer)
                {

          public void onDrawerClosed(View drawerView){super.onDrawerClosed(drawerView);}
          public void onDrawerOpened(View drawerView){super.onDrawerOpened(drawerView);}
        };
        drawer.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_farmers_home_drawer,menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawers();
            return;
        }
        super.onBackPressed();
    }
}
