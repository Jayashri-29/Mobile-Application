package com.example.farmersfriend.Utilities;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

public class My_Application extends Application {
    private static My_Application my_application;
    private SharedPreferences sharedPreferences;

    public static synchronized My_Application getInstance(){
        if (my_application == null){
            my_application = new My_Application();
        }
        return my_application;
    }
    public SharedPreferences getSharedPreferences(Context context)
    {
        if(sharedPreferences == null)
        {
            sharedPreferences=context.getSharedPreferences(Shared_Preference_Key_Constant.PREF_NAME,0);
        }
        return sharedPreferences;
    }

    @Override
    public void onCreate() { super.onCreate(); }
}
