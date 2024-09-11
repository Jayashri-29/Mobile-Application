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
import com.example.farmersfriend.Database.DatabaseAgro;
import com.example.farmersfriend.R;
import com.example.farmersfriend.Utilities.AppDatabase;
import com.example.farmersfriend.Utilities.Shared_Preference_manager;
import com.example.farmersfriend.Utilities.UtilityMethod;

public class EquipmentFragment extends Fragment implements View.OnClickListener {
    ImageView img_Equipment;
    public static final int CAMERA_REQUEST=20;
    TextView txtgalleryEqui;
    private Bitmap imgbit;
    BitmapFactory.Options options=new BitmapFactory.Options();
    EditText edteqiname,edteqibrand,edtrent,edteqiprice;
    Button btnaddeqipment;
    Uri uri;
    Context context;
    public static final int GALLERY_REQUEST=32;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context=context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_equipment,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        img_Equipment=view.findViewById(R.id.img_spray);
        txtgalleryEqui=view.findViewById(R.id.txtgalleryEqui);
        edteqiname=view.findViewById(R.id.edteqiname);
        edteqibrand=view.findViewById(R.id.edteqibrand);
        edteqiprice=view.findViewById(R.id.edteqiprice);
        edtrent=view.findViewById(R.id.edtrent);
        btnaddeqipment = view.findViewById(R.id.btnaddeqipment);
        btnaddeqipment.setOnClickListener(this);

        img_Equipment.setOnClickListener(this);
        txtgalleryEqui.setOnClickListener(this);

        ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.CAMERA
        ,Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE},20);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onClick(View v) {

        if (v.getId()==R.id.btnaddeqipment) {
            EquipmentModel equipmentModel = new EquipmentModel();
            equipmentModel.setNav_equitext_name(edteqiname.getText().toString());
            equipmentModel.setNav_equitext_brand(edteqibrand.getText().toString());
            equipmentModel.setNav_equitext_Rent(UtilityMethod.convertStringToFloat(edtrent.getText().toString()));
            equipmentModel.setNav_equitext_price(UtilityMethod.convertStringToFloat(edteqiprice.getText().toString()));

            equipmentModel.setImageview(UtilityMethod.imgConvertFromBitmapToByteArray(imgbit));

            DatabaseAgro.getInstance(context).getAppDatabase()
                    .equipmentDAO().insertEquipmentModel(equipmentModel);
            Toast.makeText(context, "Insert Successfull", Toast.LENGTH_SHORT).show();
        }
        if(v.getId()==R.id.img_spray) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, CAMERA_REQUEST);
        }
        if (v.getId()==R.id.txtgalleryEqui)
        {
            Intent  intent=new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent,GALLERY_REQUEST);


        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==CAMERA_REQUEST)
        {
           imgbit=(Bitmap)data.getExtras().get("data");
            img_Equipment.setImageBitmap(imgbit);
        }
        if(requestCode==GALLERY_REQUEST)
        {
            Uri selectedImage =data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            if(selectedImage != null)
            {
                Cursor cursor = context.getContentResolver()
                        .query(selectedImage,filePathColumn,null,null,null);
                if (cursor != null) {
                    cursor.moveToFirst();
                    int columIndex = cursor.getColumnIndex(filePathColumn[0]);
                    String picturePath = cursor.getString(columIndex);
                    options.inSampleSize=2;
                   imgbit=BitmapFactory.decodeFile(picturePath,options);
                   img_Equipment.setImageBitmap(imgbit);
                    cursor.close();

                }
            }
        }
    }
}
