package com.example.farmersfriend.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.farmersfriend.DataModels.BookingModel;
import com.example.farmersfriend.DataModels.HomeModel;

import java.util.List;
@Dao

public interface HomeDAO {
    @Query("SELECT * FROM HomeModel")
    List<HomeModel> getAllEntry();

    @Insert
    long insertHomeModel(HomeModel hm);

    @Update
    void updateHomeModel(HomeModel hm);

    @Delete
    void deleteHomeModel(HomeModel hm);

}


