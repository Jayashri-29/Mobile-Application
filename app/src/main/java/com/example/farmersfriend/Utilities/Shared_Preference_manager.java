package com.example.farmersfriend.Utilities;

import android.content.Context;

public class Shared_Preference_manager {
    public static boolean setUser_ID(Context context,long User_Id)
    {
        return My_Application.getInstance().getSharedPreferences(context).edit().
                putLong(Shared_Preference_Key_Constant.USER_ID,User_Id).commit();

    }
    public static long getUser_ID(Context context)
    {
        return My_Application.getInstance().getSharedPreferences(context)
                .getLong(Shared_Preference_Key_Constant.USER_ID,0);
    }
    public static boolean setUser_Name(Context context,String User_Name)
    {
        return My_Application.getInstance().getSharedPreferences(context).edit().
                putString(Shared_Preference_Key_Constant.USER_NAME,User_Name).commit();

    }
    public static String getUser_Name(Context context)
    {
        return My_Application.getInstance().getSharedPreferences(context)
                .getString(Shared_Preference_Key_Constant.USER_NAME,"");
    }
    public static boolean setUser_Type(Context context,String User_Type)
    {
        return My_Application.getInstance().getSharedPreferences(context).edit().
                putString(Shared_Preference_Key_Constant.USER_TYPE,User_Type).commit();

    }
    public static int getUser_Type(Context context)
    {
        return My_Application.getInstance().getSharedPreferences(context)
                .getInt(Shared_Preference_Key_Constant.USER_TYPE,0);
    }
    public static boolean setEmail(Context context,String User_Email)
    {
        return My_Application.getInstance().getSharedPreferences(context).edit().
                putString(Shared_Preference_Key_Constant.USER_EMAIL,User_Email).commit();

    }
    public static String getEmail(Context context)
    {
        return My_Application.getInstance().getSharedPreferences(context)
                .getString(Shared_Preference_Key_Constant.USER_EMAIL,"");
    }
    public static boolean setUser_Mobile(Context context,String Mob_No)
    {
        return My_Application.getInstance().getSharedPreferences(context).edit().
                putString(Shared_Preference_Key_Constant.USER_MOB_NO,Mob_No).commit();

    }
    public static String getUser_Mobile(Context context)
    {
        return My_Application.getInstance().getSharedPreferences(context)
                .getString(Shared_Preference_Key_Constant.USER_MOB_NO,"");
    }

    public static boolean setCartList(Context context,String listString) {
        return My_Application.getInstance().getSharedPreferences(context).edit()
                .putString(Shared_Preference_Key_Constant.CARTLISY, listString).commit();
    }
    public static String getCartList(Context context) {
        return My_Application.getInstance().getSharedPreferences(context)
                .getString(Shared_Preference_Key_Constant.CARTLISY, "");

    }

}
