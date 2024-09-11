package com.example.farmersfriend.Utilities;

import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.farmersfriend.DAO.BookingDAO;
import com.example.farmersfriend.DAO.CartDAO;
import com.example.farmersfriend.DAO.EquipmentDAO;
import com.example.farmersfriend.DAO.HomeDAO;
import com.example.farmersfriend.DAO.OrderDAO;
import com.example.farmersfriend.DAO.OrderItemDAO;
import com.example.farmersfriend.DAO.ProductDAO;
import com.example.farmersfriend.DAO.UserDAO;
import com.example.farmersfriend.DataModels.BookingModel;
import com.example.farmersfriend.DataModels.CartModel;
import com.example.farmersfriend.DataModels.EquipmentModel;
import com.example.farmersfriend.DataModels.HomeModel;
import com.example.farmersfriend.DataModels.OrderItemModel;
import com.example.farmersfriend.DataModels.OrderModel;
import com.example.farmersfriend.DataModels.ProductModel;
import com.example.farmersfriend.DataModels.UserModel;

@Database(entities = {UserModel.class,ProductModel.class, BookingModel.class,
        OrderModel.class, OrderItemModel.class,
        EquipmentModel.class,CartModel.class, HomeModel.class}
,version = 1,exportSchema = false)

public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDAO userDAO();
    public abstract EquipmentDAO equipmentDAO();
    public abstract ProductDAO productDAO();
    public abstract OrderDAO orderDAO();
    public abstract OrderItemDAO orderItemDAO();
    public abstract BookingDAO bookingDAO();
    public abstract CartDAO cartDAO();
    public abstract HomeDAO homeDAO();



}
