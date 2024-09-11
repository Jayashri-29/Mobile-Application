package com.example.farmersfriend.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.TextUtilsCompat;

import com.example.farmersfriend.DataModels.UserModel;
import com.example.farmersfriend.Database.DatabaseAgro;
import com.example.farmersfriend.R;
import com.example.farmersfriend.Utilities.EmailValidator;
import com.example.farmersfriend.Utilities.Shared_Preference_manager;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnsubmit;
    EditText edtname, edtemail, edtMoNo, edtpwd, edtCpwd;
    private TextView txtALogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resistration_layout);
        edtname = findViewById(R.id.edtname);
        edtemail = findViewById(R.id.edtemail);
        edtMoNo = findViewById(R.id.edtMoNo);
        edtpwd = findViewById(R.id.edtpwd);
        edtCpwd = findViewById(R.id.edtCpwd);

        txtALogin = findViewById(R.id.txtALogin);

        btnsubmit = findViewById(R.id.btnsubmit);
        btnsubmit.setOnClickListener(this);
        txtALogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        EmailValidator emailValidator = new EmailValidator();
        if (!TextUtils.isEmpty(edtemail.getText().toString()) &&
                !TextUtils.isEmpty(edtname.getText().toString())
                && !TextUtils.isEmpty(edtMoNo.getText().toString())) {
            if (emailValidator.validate(edtemail.getText().toString()) == true) {
                if (btnsubmit.getId() == v.getId()) {

                    if (v.getId() == R.id.btnsubmit) {
                        UserModel userModel = new UserModel();
                        userModel.setEdtName(edtname.getText().toString());
                        userModel.setEdtEmail(edtemail.getText().toString());
                        userModel.setEdtContact(edtMoNo.getText().toString());
                        userModel.setEdtPsw(edtpwd.getText().toString());
                        long u_Id = DatabaseAgro.getInstance(getApplicationContext())
                                .getAppDatabase().userDAO().insertUserModel(userModel);
                        Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show();

                        Shared_Preference_manager.setUser_ID(RegistrationActivity.this, u_Id);
                        Shared_Preference_manager.setUser_Name(RegistrationActivity.this,edtname.getText().toString());
                        Shared_Preference_manager.setUser_Mobile(RegistrationActivity.this, edtMoNo.getText().toString());
                        Shared_Preference_manager.setEmail(RegistrationActivity.this, edtemail.getText().toString());


                        if (TextUtils.equals(edtCpwd.getText().toString(), edtpwd.getText().toString())) {
                            Toast.makeText(this, "Password is created", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(this, LoginActivity.class);
                            startActivity(intent);

                        } else {
                            Toast.makeText(this, "Password is missmatch", Toast.LENGTH_SHORT).show();
                        }

                    }
                }



            }
            else {
                Toast.makeText(this, "Email is not valid", Toast.LENGTH_SHORT).show();
            }


        }
        else {
            Toast.makeText(this, "Enter All the Fields", Toast.LENGTH_SHORT).show();
        }
        if (v.getId() == txtALogin.getId()) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
    }
}





