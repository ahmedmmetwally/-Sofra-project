
package com.example.mysofra.data.model.restaurntDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RestaurntDetails {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("data")
    @Expose
    private RestaurntDetailsData data;

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

    public RestaurntDetailsData getData() {
        return data;
    }

    public void setData(RestaurntDetailsData data) {
        this.data = data;
    }

}
