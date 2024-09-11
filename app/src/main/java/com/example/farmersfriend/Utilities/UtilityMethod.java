package com.example.farmersfriend.Utilities;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilityMethod {


    public static String getDateAndTime()
    {
        DateFormat df=new SimpleDateFormat("dd-MM-yyy hh:mm");
        Date date=new Date();
        return df.format(date);
    }

    public static String convertIntToString(int iNumber)
    {
        return String.valueOf(iNumber);
    }

    public static String convertFloatToString(float fNumber)
    {
        return String.valueOf(fNumber);
    }

    public static String convertLongToString(long lNumber)
    {
        return String.valueOf(lNumber);
    }

    public static int convertStringToInt(String sNumber) {
        return Integer.parseInt(sNumber);
    }

    public static float convertStringToFloat(String sNumber) {
        return Float.parseFloat(sNumber);
    }

    public static float convertStringToLong(String sNumber) {
        return Long.parseLong(sNumber);
    }

    public static byte[] imgConvertFromBitmapToByteArray(Bitmap bitmap)
    {
        ByteArrayOutputStream blob =new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,0,blob);
        return  blob.toByteArray();
    }
    public static Bitmap imgConvertFromByteArrayToBitmap(byte[] image)
    {
        return BitmapFactory.decodeByteArray(image,0,image.length);
    }
    public static String getUserNameFromEmail(String email)
    {
        return email.substring(0,email.indexOf('@'));
    }

}
