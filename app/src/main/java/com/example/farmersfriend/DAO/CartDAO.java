package com.example.farmersfriend.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.farmersfriend.DataModels.CartModel;
import com.example.farmersfriend.DataModels.UserModel;

import java.util.List;
@Dao
public interface CartDAO {
    @Query("SELECT * FROM CartModel")
    List<CartModel> getAllCart();
    @Insert
    long insertCartModel(CartModel C);
    @Update
    void updateCartModel(CartModel C);
    @Delete
    void deleteCartModel(CartModel C);

    @Query("SELECT * FROM CartModel where cartId=:cartid")
    CartModel cart(long cartid);


}
