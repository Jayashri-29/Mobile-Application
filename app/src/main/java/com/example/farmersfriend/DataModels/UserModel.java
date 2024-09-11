package com.example.farmersfriend.DataModels;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class UserModel implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int u_id;

    @ColumnInfo(name = "edtName")
    private String edtName;

    @ColumnInfo(name = "edtEmail")
    private String edtEmail;

    @ColumnInfo(name = "edtContact")
    private String edtContact;

    @ColumnInfo(name = "edtPsw")
    private String edtPsw;

@Ignore
    public UserModel(int u_id, String edtName, String edtEmail, String edtContact, String edtPsw) {
        this.u_id = u_id;
        this.edtName = edtName;
        this.edtEmail = edtEmail;
        this.edtContact = edtContact;
        this.edtPsw = edtPsw;
    }

    public UserModel() {
    }

    public int getU_id() {
        return u_id;
    }

    public String getEdtName() {
        return edtName;
    }

    public String getEdtEmail() {
        return edtEmail;
    }

    public String getEdtContact() {
        return edtContact;
    }

    public String getEdtPsw() {
        return edtPsw;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public void setEdtName(String edtName) {
        this.edtName = edtName;
    }

    public void setEdtEmail(String edtEmail) {
        this.edtEmail = edtEmail;
    }

    public void setEdtContact(String edtContact) {
        this.edtContact = edtContact;
    }

    public void setEdtPsw(String edtPsw) {
        this.edtPsw = edtPsw;
    }
}