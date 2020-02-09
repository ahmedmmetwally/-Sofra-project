
package com.example.mysofra.data.model.clientOffers;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClientOffers {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("data")
    @Expose
    private ClientOffersData data;

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

    public ClientOffersData getData() {
        return data;
    }

    public void setData(ClientOffersData data) {
        this.data = data;
    }

}
