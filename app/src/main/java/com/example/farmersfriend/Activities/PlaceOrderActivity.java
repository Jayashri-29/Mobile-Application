package com.example.farmersfriend.Activities;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.farmersfriend.DataModels.CartModel;
import com.example.farmersfriend.DataModels.OrderItemModel;
import com.example.farmersfriend.DataModels.OrderModel;
import com.example.farmersfriend.Database.DatabaseAgro;
import com.example.farmersfriend.R;
import com.example.farmersfriend.Utilities.Shared_Preference_manager;
import com.example.farmersfriend.Utilities.UtilityMethod;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.razorpay.Checkout;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PlaceOrderActivity extends AppCompatActivity implements View.OnClickListener, com.example.farmersfriend.DAO.PlaceOrder {


    EditText edtname, edtmob, edttown,edtmode, edtstate, edtflat, edtland;
    Button btnplaceod,btnpay;
    TextView txtTotalAmt, txtDate, txtTime;
    private float totalAmt;

    CartModel productCartModel;

    List<CartModel> cartList=new ArrayList<>();
    private EditText edtArea;
    private EditText edtAddress;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_placeorder);
        getSupportActionBar().setTitle("Place Order");
        Gson gson=new Gson();

        String sList= Shared_Preference_manager.getCartList(this);

        cartList=gson.fromJson(sList,new TypeToken<List<CartModel>>(){}.getType());

        totalAmt=getIntent().getFloatExtra("totalAmt",0);

        edtname=findViewById(R.id.edtname);
        edtmob=findViewById(R.id.edtmob);
        edttown=findViewById(R.id.edttown);
        edtArea=findViewById(R.id.edtArea);
        edtmode=findViewById(R.id.edtmode);
        edtAddress=findViewById(R.id.edtAddress);
        txtTotalAmt=findViewById(R.id.txtTotalAmt);
        btnplaceod=findViewById(R.id.btnplaceod);
        btnpay=findViewById(R.id.btnpay);

        btnpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Checkout checkout = new Checkout();
                checkout.setKeyID("rzp_test_rCsSeHlxh01pyZ");
                checkout.setImage(R.drawable.agricon);
                String amount = String.valueOf(totalAmt);
                int Amt = Math.round(Float.parseFloat(amount)*100);
                JSONObject object = new JSONObject();
                try {
                    object.put("name","Farmers Friend");
                    object.put("description","Online payment");
                    object.put("theme.color","#0093DD");
                    object.put("currency","INR");
                    object.put("amount",Amt);
                    object.put("prefill.contact","9955228765");
                    object.put("prefill.email","farmersfriend@gmail.com");
                    checkout.open(PlaceOrderActivity.this,object);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });




        txtTotalAmt.setText("Total:"+getResources().getString(R.string.rs_Symbol)+" "+ UtilityMethod.convertFloatToString(totalAmt));
        btnplaceod.setOnClickListener(this);
    }

    @Override
    public void onPaymentSuccess(String s){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Payment ID");
        builder.setMessage(s);
        builder.show();
    }

    @Override
    public void onPaymentError(int i, String s){
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
    }




    @Override
    public void onClick(View v) {
        if (v.getId()==btnplaceod.getId())
        {
            OrderModel productOrderModel = new OrderModel();

            if(!TextUtils.isEmpty(edtname.getText().toString())
                    &&  !TextUtils.isEmpty(edtmob.getText().toString())
                    &&  !TextUtils.isEmpty(edtname.getText().toString())
                    &&  !TextUtils.isEmpty(edttown.getText().toString())
            ) {

                productOrderModel.setC_name(edtname.getText().toString());
                productOrderModel.setOrderdate(UtilityMethod.getDateAndTime());
                productOrderModel.setC_address(edtAddress.getText().toString());
                productOrderModel.setC_city(edttown.getText().toString());
               // productOrderModel.setC_mode(edtmode.getText().toString());
                productOrderModel.setC_mob(edtmob.getText().toString());
                productOrderModel.setAmount(totalAmt);

                saveProduct(productOrderModel);
                clearcontrol();

                Toast.makeText(PlaceOrderActivity.this, "Order Placed Sucessfully", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(PlaceOrderActivity.this, "Enter The Valid Data", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void clearcontrol()
    {
        edtname.setText("");
        edtmob.setText("");
        edttown.setText("");
        edtArea.setText("");
        edtAddress.setText("");
        txtTotalAmt.setText("");
    }

    private void saveProduct(OrderModel productOrderModel)
    {
        long lastOid = DatabaseAgro.getInstance(getApplicationContext())
                .getAppDatabase()
                .orderDAO()
                .insertOrderModel(productOrderModel);

        List<OrderItemModel> oItemList = new ArrayList<>();
        for (CartModel pcm: cartList)
        {
            OrderItemModel orderItemModel=new OrderItemModel();
            orderItemModel.setAmount(pcm.getPrice());
            orderItemModel.setQuantity(pcm.getQuantity());
            orderItemModel.setProductName(pcm.getName());
            orderItemModel.setOrderId(lastOid);

            DatabaseAgro.getInstance(getApplicationContext())
                    .getAppDatabase()
                    .orderItemDAO()
                    .insertOrderItemModel(orderItemModel);
                    oItemList.add(orderItemModel);
        }

       /* DatabaseClient.getInstance(getApplicationContext())
                .getAppDatabase()
                .cartDao()
                .deleteAll();*/
    }
}