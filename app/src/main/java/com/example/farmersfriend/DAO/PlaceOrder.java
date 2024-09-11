package com.example.farmersfriend.DAO;

public interface PlaceOrder {
    void onPaymentSuccess(String s);

    void onPaymentError(int i, String s);
}
