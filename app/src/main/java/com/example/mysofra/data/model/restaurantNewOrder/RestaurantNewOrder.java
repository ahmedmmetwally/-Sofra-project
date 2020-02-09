
package com.example.mysofra.data.model.restaurantNewOrder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RestaurantNewOrder {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("data")
    @Expose
    private RestaurantNewOrderData data;

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

    public RestaurantNewOrderData getData() {
        return data;
    }

    public void setData(RestaurantNewOrderData data) {
        this.data = data;
    }

}
