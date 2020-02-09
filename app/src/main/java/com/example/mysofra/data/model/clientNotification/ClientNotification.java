
package com.example.mysofra.data.model.clientNotification;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClientNotification {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("data")
    @Expose
    private ClientNotificationData data;

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

    public ClientNotificationData getData() {
        return data;
    }

    public void setData(ClientNotificationData data) {
        this.data = data;
    }

}
