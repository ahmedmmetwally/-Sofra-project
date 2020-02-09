
package com.example.mysofra.data.model.contactWithUs;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ContactWithUs {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("data")
    @Expose
    private ContactWithUsData data;

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

    public ContactWithUsData getData() {
        return data;
    }

    public void setData(ContactWithUsData data) {
        this.data = data;
    }

}
