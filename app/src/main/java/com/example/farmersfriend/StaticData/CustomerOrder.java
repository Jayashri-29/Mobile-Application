package com.example.farmersfriend.StaticData;

public class CustomerOrder {
    String Name,Contact,Product_Name,Price;


    public CustomerOrder( String Name, String contact,String Product_Name, String Price ) {
        this.Name = Name;

        this.Contact = contact;
        this.Product_Name=Product_Name;
        this.Price=Price;
    }


    public String getName() {
        return Name;
    }


    public String getContact() {
        return Contact;
    }
    public String getProduct_Name() {
        return Product_Name;
    }
    public String getPrice() {
        return Price;
    }



}
