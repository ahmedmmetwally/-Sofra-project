
package com.example.mysofra.data.model.editProfileClient;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EditProfileClient {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("data")
    @Expose
    private EditProfileClientData data;

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

    public EditProfileClientData getData() {
        return data;
    }

    public void setData(EditProfileClientData data) {
        this.data = data;
    }

}
