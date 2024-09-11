package com.example.farmersfriend.Activities;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farmersfriend.Adapters.OrderItemAdapter;
import com.example.farmersfriend.DataModels.OrderItemModel;
import com.example.farmersfriend.DataModels.OrderModel;
import com.example.farmersfriend.Database.DatabaseAgro;
import com.example.farmersfriend.R;
import com.example.farmersfriend.Utilities.UtilityMethod;

import java.util.List;

public class ShowOrderActivity extends AppCompatActivity
{
    TextView txtdate, txttime,txtcname, txtpay, txtinfo, txtitem, txttotal,txtTown,txtState,txtFlat,txtLand, txtMob;
    private OrderModel order;
    private RecyclerView rv_order_item;
    private long orderId;
    private List<OrderItemModel> orderItemList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showdetailorderlayout);

        getSupportActionBar().setTitle("Order Details");
        txtdate=findViewById(R.id.txtdate);
        txtMob=findViewById(R.id.txtMob);
        txtpay=findViewById(R.id.txtpay);
        txtinfo=findViewById(R.id.txtinfo);
        txttotal=findViewById(R.id.txttotal);
        txtTown=findViewById(R.id.txtAddDetail);
        txtcname=findViewById(R.id.txtcname);


        order=(OrderModel) getIntent().getSerializableExtra("order");

        txttotal.setText("Total:"+getResources().getString(R.string.rs_Symbol)+" "+ UtilityMethod.convertFloatToString(order.getAmount()));

        txtTown.setText(order.getC_address()+","+","+order.getC_city());
        txtdate.setText(order.getOrderdate());
        txtcname.setText(order.getC_name());
        txtMob.setText(order.getC_mob());
        //txtMob.setText(order.getC_pin());

        rv_order_item = findViewById(R.id.rv_otder_item);
        
        orderItemList = DatabaseAgro.getInstance(getApplicationContext())
                .getAppDatabase().orderItemDAO()
                .getItemsByOrderId((long)order.getOrderId());


        rv_order_item.setAdapter(new OrderItemAdapter(orderItemList,this));
        rv_order_item.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
    }
}
