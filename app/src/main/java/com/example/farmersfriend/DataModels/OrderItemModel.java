package com.example.farmersfriend.DataModels;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

import androidx.room.PrimaryKey;

import java.io.Serializable;
@Entity
public class OrderItemModel implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int OrderitemId;

    @ColumnInfo(name = "productName")
    private String productName;

    @ColumnInfo(name = "amount")
    private float amount;

    @ColumnInfo(name = "quantity")
    private int quantity;

    @ColumnInfo(name = "OrderId")
    private long orderId;

    public OrderItemModel() {
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public int getOrderitemId() {
        return OrderitemId;
    }

    public String getProductName() {
        return productName;
    }

    public void setOrderitemId(int orderitemId) {
        OrderitemId = orderitemId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }



    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
