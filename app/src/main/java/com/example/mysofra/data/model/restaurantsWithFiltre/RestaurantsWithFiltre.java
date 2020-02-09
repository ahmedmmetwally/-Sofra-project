
package com.example.mysofra.data.model.restaurantsWithFiltre;

import com.example.mysofra.data.model.listOfRestaurants.ListOfRestaurantsData;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RestaurantsWithFiltre {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("data")
    @Expose
    private ListOfRestaurantsData data;

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

    public ListOfRestaurantsData getData() {
        return data;
    }

    public void setData(ListOfRestaurantsData data) {
        this.data = data;
    }

}
