package com.example.farmersfriend.DataModels;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
@Entity
public class OrderModel implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int OrderId;

    @ColumnInfo(name = "orderdate")
    private String orderdate;

    @ColumnInfo(name = "amount")
    private float amount;

    @ColumnInfo(name = "C_name")
    private String C_name;

    @ColumnInfo(name = "C_address")
    private String C_address;

    @ColumnInfo(name = "C_city")
    private String C_city;

    @ColumnInfo(name = "C_pin")
    private String C_pin;

    @ColumnInfo(name = "C_mob")
    private String C_mob;

   // @ColumnInfo(name ="C_mode")
   // private String C_mode;


    public OrderModel() {
    }

    //public String getC_mode() {
    //return C_mode;
    //}

   //public void setC_mode(String C_mode) {
       // this.C_mode =C_mode;
   // }


    public int getOrderId(){return OrderId ;}
   public void setOrderId(int orderId) { OrderId = orderId; }

    public String getOrderdate() { return orderdate; }
    public void setOrderdate(String orderdate) { this.orderdate = orderdate; }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getC_name() {
        return C_name;
    }

    public void setC_name(String c_name) {
        C_name = c_name;
    }

    public String getC_address() {
        return C_address;
    }

    public void setC_address(String c_address) {
        C_address = c_address;
    }

    public String getC_city() {
        return C_city;
    }

    public void setC_city(String c_city) {
        C_city = c_city;
    }

    public String getC_pin() {
        return C_pin;
    }

    public void setC_pin(String c_pin) {
        C_pin = c_pin;
    }

    public String getC_mob() { return C_mob; }

    public void setC_mob(String c_mob) {
        C_mob = c_mob;
    }

}