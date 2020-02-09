
package com.example.mysofra.data.model.clientOrderById;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClientOrderById {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("data")
    @Expose
    private ClientOrderByIdData data;

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

    public ClientOrderByIdData getData() {
        return data;
    }

    public void setData(ClientOrderByIdData data) {
        this.data = data;
    }

}
