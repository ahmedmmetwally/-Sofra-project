
package com.example.mysofra.data.model.restaurantUpdateCategory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RestaurantUpdateCategory {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("data")
    @Expose
    private RestaurantUpdateCategoryData data;

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

    public RestaurantUpdateCategoryData getData() {
        return data;
    }

    public void setData(RestaurantUpdateCategoryData data) {
        this.data = data;
    }

}
