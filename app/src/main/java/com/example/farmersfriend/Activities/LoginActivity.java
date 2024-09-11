package com.example.farmersfriend.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.farmersfriend.DataModels.UserModel;
import com.example.farmersfriend.Database.DatabaseAgro;
import com.example.farmersfriend.FarmersHomeActivity;
import com.example.farmersfriend.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnlogin;
    EditText edtlogpsw,edtlogemail;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        edtlogemail=findViewById(R.id.edtlogemail);
        edtlogpsw=findViewById(R.id.edtlogpsw);
        btnlogin=findViewById(R.id.btnlogin);
        btnlogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.btnlogin)
        {
            if(edtlogemail.getText().toString().equals("admin") &&
                    edtlogpsw.getText().toString().equals("admin"))
            {
                Intent intent=new Intent(this, AdminHomeActivity.class);
                startActivity(intent);
            }else {

                UserModel userModel= DatabaseAgro.getInstance(getApplicationContext())
                        .getAppDatabase().userDAO().userLogin(edtlogemail.getText().toString(),
                                edtlogpsw.getText().toString());
                if (userModel != null)
                {
                    Intent intent=new Intent(this, FarmersHomeActivity.class);
                    startActivity(intent);
                    Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "You are not register", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
