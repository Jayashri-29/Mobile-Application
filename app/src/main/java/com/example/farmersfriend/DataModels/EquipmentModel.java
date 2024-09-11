package com.example.farmersfriend.DataModels;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;
@Entity
public class EquipmentModel implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int nav_equiId;

    @ColumnInfo(name = "imageview")
            private byte[] imageview;

    @ColumnInfo(name = "nav_equitext_name")
    private String nav_equitext_name;

    @ColumnInfo(name = "nav_equitext_brand")
    private String nav_equitext_brand;

    @ColumnInfo(name = "nav_equitext_Rent")
    private float nav_equitext_Rent;

    @ColumnInfo(name = "nav_equitext_price")
    private float nav_equitext_price;


    public EquipmentModel() {

    }


    public int getNav_equiId() {
        return nav_equiId;
    }
    public void setNav_equiId(int nav_equiId) { this.nav_equiId = nav_equiId; }

    public String getNav_equitext_name() {
        return nav_equitext_name;
    }
    public void setNav_equitext_name(String nav_equitext_name) {
        this.nav_equitext_name = nav_equitext_name;
    }

    public String getNav_equitext_brand() {
        return nav_equitext_brand;
    }
    public void setNav_equitext_brand(String nav_equitext_brand) {
        this.nav_equitext_brand = nav_equitext_brand;
    }

    public float getNav_equitext_Rent() {
        return nav_equitext_Rent;
    }

    public void setNav_equitext_Rent(float nav_equitext_Rent) {
        this.nav_equitext_Rent = nav_equitext_Rent;
    }

    public float getNav_equitext_price() {
        return nav_equitext_price;
    }

    public void setNav_equitext_price(float nav_equitext_price) {
        this.nav_equitext_price = nav_equitext_price;
    }

    public byte[] getImageview() {
        return imageview;
    }

    public void setImageview(byte[] imageview) {
        this.imageview = imageview;
    }
}

