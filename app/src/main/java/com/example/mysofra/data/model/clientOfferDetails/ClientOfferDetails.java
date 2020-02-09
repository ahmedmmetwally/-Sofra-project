
package com.example.mysofra.data.model.clientOfferDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClientOfferDetails {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("data")
    @Expose
    private ClientOfferDetailsData data;

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

    public ClientOfferDetailsData getData() {
        return data;
    }

    public void setData(ClientOfferDetailsData data) {
        this.data = data;
    }

}
