package com.example.farmersfriend.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.farmersfriend.DataModels.ProductModel;
import com.example.farmersfriend.DataModels.UserModel;

import java.util.List;
@Dao
public interface ProductDAO {
    @Query("SELECT * FROM ProductModel")
    List<ProductModel> getAllProduct();
    @Insert
    long insertProductModel(ProductModel productModel);
    @Update
    void updateProductModel(ProductModel productModel);
    @Delete
    void deleteProductModel(ProductModel productModel);
    @Query("SELECT * FROM ProductModel where nav_proId =:proId")
    ProductModel product(long proId);

}
