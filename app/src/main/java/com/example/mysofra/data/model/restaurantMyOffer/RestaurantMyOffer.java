
package com.example.mysofra.data.model.restaurantMyOffer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RestaurantMyOffer {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("data")
    @Expose
    private RestaurantMyOfferData data;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public RestaurantMyOfferData getData() {
        return data;
    }

    public void setData(RestaurantMyOfferData data) {
        this.data = data;
    }

}
