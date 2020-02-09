
package com.example.mysofra.data.model.clientAddCommit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClientAddCommit {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("data")
    @Expose
    private ClientAddCommitData data;

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

    public ClientAddCommitData getData() {
        return data;
    }

    public void setData(ClientAddCommitData data) {
        this.data = data;
    }

}
