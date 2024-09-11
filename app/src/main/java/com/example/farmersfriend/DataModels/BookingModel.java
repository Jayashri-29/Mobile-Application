package com.example.farmersfriend.DataModels;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class BookingModel implements Serializable {

    @PrimaryKey(autoGenerate = true)
    int bookId;

    @ColumnInfo(name = "frDate")
    String frDate;

    @ColumnInfo(name = "toDate")
    String toDate;


    @ColumnInfo(name = "eqpName")
    String eqpName;

    @ColumnInfo(name = "eqpRent")
    float eqpRent;

    @ColumnInfo(name = "custName")
    String custName;

    public BookingModel() {
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getFrDate() {
        return frDate;
    }

    public void setFrDate(String frDate) {
        this.frDate = frDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getEqpName() {
        return eqpName;
    }

    public void setEqpName(String eqpName) {
        this.eqpName = eqpName;
    }

    public float getEqpRent() {
        return eqpRent;
    }

    public void setEqpRent(float eqpRent) {
        this.eqpRent = eqpRent;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }
}
