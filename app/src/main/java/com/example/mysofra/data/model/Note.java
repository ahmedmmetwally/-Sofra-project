package com.example.mysofra.data.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_table")
public class Note {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private int restaurant_id;
    private String photo_url;
    private String restaurantName;
    private String itmeName;
    private Float price;
    private String specialOrder;
    private int quantity;
//    private float TOTAL_PRICE_cons =0.0f;

    public Note(int restaurant_id,String photo_url, String restaurantName, String itmeName
            , Float price, String specialOrder, int quantity) {
        this.restaurant_id=restaurant_id;
        this.photo_url = photo_url;
        this.restaurantName = restaurantName;
        this.itmeName = itmeName;
        this.price = price;
        this.specialOrder = specialOrder;
        this.quantity = quantity;
//        TOTAL_PRICE_cons+=price;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getRestaurant_id() {
        return restaurant_id;
    }


    public String getPhoto_url() {
        return photo_url;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public String getItmeName() {
        return itmeName;
    }

    public Float getPrice() {
        return price;
    }

    public String getSpecialOrder() {
        return specialOrder;
    }

    public int getQuantity() {
        return quantity;
    }

//    public float getTotal_price() {
//        return TOTAL_PRICE_cons;
//    }
//
//    public void setTotal_price(float TOTAL_PRICE_cons) {
//        this.TOTAL_PRICE_cons = TOTAL_PRICE_cons;
//    }
}
