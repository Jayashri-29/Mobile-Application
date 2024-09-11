package com.example.farmersfriend.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.farmersfriend.DataModels.OrderItemModel;
import com.example.farmersfriend.DataModels.UserModel;

import java.util.List;
@Dao
public interface OrderItemDAO {
    @Query("SELECT * FROM OrderItemModel")
    List<OrderItemModel> getAllOrderItem();
    @Insert
    long insertOrderItemModel(OrderItemModel orderItemModel);
    @Update
    void updateOrderItemModel(OrderItemModel orderItemModel);
    @Delete
    void deleteOrderItemModel(OrderItemModel orderItemModel);

    @Query("SELECT * FROM OrderItemModel where OrderitemId=:orderItmId")
    OrderItemModel orderitem(long orderItmId);

    @Query("SELECT * FROM OrderItemModel WHERE OrderId = :oId")
    List<OrderItemModel> getItemsByOrderId(long oId);
}
