package com.example.farmersfriend.DataModels;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;
@Entity
public class ProductModel implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int nav_proId;

    @ColumnInfo(name = "proimageview")
    private byte[] proimageview;

    @ColumnInfo(name = "nav_protxt_name")
    private String nav_protxt_name;

    @ColumnInfo(name = "nav_protxt_brand")
    private String nav_protxt_brand;

    @ColumnInfo(name = "nav_protxt_mfDate")
    private String nav_protxt_mfDate;

    @ColumnInfo(name = "nav_protxt_ExDate")
    private String nav_protxt_ExDate;

    @ColumnInfo(name = "nav_protxt_price")
    private float nav_protxt_price;


    public ProductModel() {
    }


    public int getNav_proId() {
        return nav_proId;
    }
    public void setNav_proId(int nav_proId) { this.nav_proId = nav_proId; }

    public String getNav_protxt_name() {
        return nav_protxt_name;
    }
    public void setNav_protxt_name(String nav_protxt_name) {
        this.nav_protxt_name = nav_protxt_name; }

    public String getNav_protxt_brand() {
        return nav_protxt_brand;
    }
    public void setNav_protxt_brand(String nav_protxt_brand) {
        this.nav_protxt_brand = nav_protxt_brand; }

    public String getNav_protxt_mfDate() {
        return nav_protxt_mfDate;
    }
    public void setNav_protxt_mfDate(String nav_protxt_mfDate) {
        this.nav_protxt_mfDate = nav_protxt_mfDate;
    }
    public String getNav_protxt_ExDate() {
        return nav_protxt_ExDate;
    }
    public void setNav_protxt_ExDate(String nav_protxt_ExDate) {
        this.nav_protxt_ExDate = nav_protxt_ExDate; }

    public float getNav_protxt_price() {
        return nav_protxt_price;
    }

    public void setNav_protxt_price(float nav_protxt_price) {
        this.nav_protxt_price = nav_protxt_price;
    }

    public byte[] getProimageview() {
        return proimageview;
    }

    public void setProimageview(byte[] proimageview) {
        this.proimageview = proimageview;
    }
}
