package com.example.farmersfriend.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.farmersfriend.DataModels.OrderModel;
import com.example.farmersfriend.DataModels.UserModel;

import java.util.List;
@Dao
public interface OrderDAO {
    @Query("SELECT * FROM OrderModel")
    List<OrderModel> getAllOrders();
    @Insert
    long insertOrderModel(OrderModel orderModel);
    @Update
    void updateOrderModel(OrderModel orderModel);
    @Delete
    void deleteOrderModel(OrderModel orderModel);
    @Query("SELECT * FROM OrderModel where OrderId=:orderId")
    OrderModel order(long orderId);

}
