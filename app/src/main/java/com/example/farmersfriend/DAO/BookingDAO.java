package com.example.farmersfriend.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.farmersfriend.DataModels.BookingModel;
import com.example.farmersfriend.DataModels.CartModel;

import java.util.List;

@Dao
public interface BookingDAO {
    @Query("SELECT * FROM BookingModel")
    List<BookingModel> getAllBookigs();

    @Insert
    long insertBookingModel(BookingModel bm);

    @Update
    void updateBookingModel(BookingModel bm);

    @Delete
    void deleteBookingModel(BookingModel bm);

}
