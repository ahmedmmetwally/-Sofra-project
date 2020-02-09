
package com.example.mysofra.data.model.restaurntreviewe;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RestaurntReviewe {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("data")
    @Expose
    private RestaurntRevieweData data;

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

    public RestaurntRevieweData getData() {
        return data;
    }

    public void setData(RestaurntRevieweData data) {
        this.data = data;
    }

}
