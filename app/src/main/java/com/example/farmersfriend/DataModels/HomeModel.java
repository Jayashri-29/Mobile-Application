package com.example.farmersfriend.DataModels;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class HomeModel implements Serializable {
    @PrimaryKey(autoGenerate = true)
    int productId;
    @ColumnInfo(name = "Name")
    String name;
    @ColumnInfo(name = "Contact")
    String contact;
    @ColumnInfo(name = "proName")
    String proName;

    @ColumnInfo(name = "proPrice")
    float proPrice;


    public HomeModel() {

    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public float getProPrice() {
        return proPrice;
    }

    public void setProPrice(float proPrice) {
        this.proPrice = proPrice;
    }
}
