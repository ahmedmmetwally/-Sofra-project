
package com.example.mysofra.data.model.restaurantUpdateOffer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RestauranUpdateOffer {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("data")
    @Expose
    private RestauranUpdateOfferData data;

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

    public RestauranUpdateOfferData getData() {
        return data;
    }

    public void setData(RestauranUpdateOfferData data) {
        this.data = data;
    }

}
