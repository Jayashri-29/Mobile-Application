package com.example.farmersfriend.Database;

import android.content.Context;

import androidx.room.Room;

import com.example.farmersfriend.Utilities.AppDatabase;

public class DatabaseAgro
{
    private Context context;
    private static DatabaseAgro databaseAgro;
    private AppDatabase appDatabase;

    public DatabaseAgro(Context context) {
        this.context = context;
        appDatabase = Room.databaseBuilder(context,AppDatabase.class,"FarmersFriendDb")
                .allowMainThreadQueries().build();
    }
    public static synchronized DatabaseAgro getInstance(Context context)
    {
        if(databaseAgro==null)
        {
            databaseAgro= new DatabaseAgro(context);

        }
        return databaseAgro;
    }
    public AppDatabase getAppDatabase()
    {
        return appDatabase;
    }
}
