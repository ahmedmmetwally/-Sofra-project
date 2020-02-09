
package com.example.mysofra.data.model.restaurantNewCategory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RestauranNewCategory {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("data")
    @Expose
    private RestauranNewCategoryData data;

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

    public RestauranNewCategoryData getData() {
        return data;
    }

    public void setData(RestauranNewCategoryData data) {
        this.data = data;
    }

}
