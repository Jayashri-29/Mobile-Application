package com.example.farmersfriend.Fragments;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.example.farmersfriend.DataModels.EquipmentModel;
import com.example.farmersfriend.DataModels.ProductModel;
import com.example.farmersfriend.Database.DatabaseAgro;
import com.example.farmersfriend.R;
import com.example.farmersfriend.Utilities.UtilityMethod;

public class ProductFragment extends Fragment implements View.OnClickListener {

    ImageView img_product;
    public static final int CAMERA_REQUEST=20;
    public static final int GALLARY_REQUEST=30;
    TextView txtgallery;
    Context context;
    EditText Name,Brand,Mfdate,ExDate,price;
    Button ProAdd;
    Bitmap bitmap;
    Uri uri;

    @Override
    public void onAttach(@NonNull Context context)
    {
        super.onAttach(context);
        this.context=context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_product,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        img_product=view.findViewById(R.id.img_product);
        txtgallery=view.findViewById(R.id.txtgallery);
        Name=view.findViewById(R.id.edtproductname);
        Brand = view.findViewById(R.id.edtprobrand);
        Mfdate=view.findViewById(R.id.edtMnfDate);
        ExDate=view.findViewById(R.id.edtexpdate);
        price = view.findViewById(R.id.edtPprice);
        ProAdd = view.findViewById(R.id.btnaddproduct);
        ProAdd.setOnClickListener(this);
        txtgallery.setOnClickListener(this);
        img_product.setOnClickListener(this);
        ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.CAMERA},20);
    }

    @Override
    public void onClick(View v)
    {
        if(v.getId()==R.id.btnaddproduct)
        {
            ProductModel productModel = new ProductModel();
            productModel.setNav_protxt_name(Name.getText().toString());
            productModel.setNav_protxt_brand(Brand.getText().toString());
            productModel.setNav_protxt_mfDate(Mfdate.getText().toString());
            productModel.setNav_protxt_ExDate(ExDate.getText().toString());
            productModel.setNav_protxt_price(UtilityMethod.convertStringToFloat(price.getText().toString()));
            productModel.setProimageview(UtilityMethod.imgConvertFromBitmapToByteArray(bitmap));

            DatabaseAgro.getInstance(context).getAppDatabase()
                    .productDAO().insertProductModel(productModel);
            Toast.makeText(context, "Insert Successfully", Toast.LENGTH_SHORT).show();
        }

        if(v.getId()==R.id.img_product) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, CAMERA_REQUEST);
        }
        if (v.getId()==R.id.txtgallery)
        {
          Intent  intent=new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
          startActivityForResult(intent,GALLARY_REQUEST);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST && resultCode== Activity.RESULT_OK)
        {
            Bitmap image = (Bitmap)data.getExtras().get("data");
            bitmap=image;
            img_product.setImageBitmap(image);
        }
        if(requestCode==GALLARY_REQUEST)
        {
            Uri selectedImage =data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            if(selectedImage != null)
            {
                Cursor cursor = context.getContentResolver()
                        .query(selectedImage,filePathColumn,null,null,null);
                if (cursor != null)
                {
                    cursor.moveToFirst();
                    int columIndex = cursor.getColumnIndex(filePathColumn[0]);
                    String picturePath = cursor.getString(columIndex);

                    bitmap=BitmapFactory.decodeFile(picturePath);
                    img_product.setImageBitmap(bitmap);
                    cursor.close();
                }
            }
        }
    }


    @Override
    public void onDetach()
    {
        super.onDetach();
    }

}
