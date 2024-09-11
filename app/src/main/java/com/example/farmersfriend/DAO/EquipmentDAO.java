package com.example.farmersfriend.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.farmersfriend.DataModels.EquipmentModel;
import com.example.farmersfriend.DataModels.UserModel;

import java.util.List;
@Dao
public interface EquipmentDAO {
    @Query("SELECT * FROM EquipmentModel")
    List<EquipmentModel> getAllEquipment();
    @Insert
    long insertEquipmentModel(EquipmentModel U);
    @Update
    void updateEquipmentModel(EquipmentModel U);
    @Delete
    void deleteEquipmentModel(EquipmentModel U);
    @Query("SELECT * FROM EquipmentModel where nav_equiId=:equiId")
    EquipmentModel equipment(long equiId);

}
