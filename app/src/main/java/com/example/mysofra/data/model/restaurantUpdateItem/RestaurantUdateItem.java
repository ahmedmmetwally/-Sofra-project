
package com.example.mysofra.data.model.restaurantUpdateItem;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RestaurantUdateItem {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("data")
    @Expose
    private RestaurantUdateItemData data;

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

    public RestaurantUdateItemData getData() {
        return data;
    }

    public void setData(RestaurantUdateItemData data) {
        this.data = data;
    }

}
