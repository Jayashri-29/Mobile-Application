package com.example.farmersfriend.DataModels;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;
@Entity
public class CartModel implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int cartId;

    @ColumnInfo(name = "imageview")
    private byte[] imageview;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "quantity")
    private int quantity;

    @ColumnInfo(name = "price")
    private float price;


    public CartModel() {
    }

    public int getCartId() {
        return cartId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }


    public void setCartId(int cartId) {
        this.cartId = cartId;
    }


    public void setName(String name) {
        this.name = name;
    }


    public byte[] getImageview() {
        return imageview;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setImageview(byte[] imageview) {
        this.imageview = imageview;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
