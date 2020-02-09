
package com.example.mysofra.data.model.clientlogin;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClientloginData {

    @SerializedName("api_token")
    @Expose
    private String apiToken;
    @SerializedName("user")
    @Expose
    private ClientloginUser user;

    public String getApiToken() {
        return apiToken;
    }

    public void setApiToken(String apiToken) {
        this.apiToken = apiToken;
    }

    public ClientloginUser getUser() {
        return user;
    }

    public void setUser(ClientloginUser user) {
        this.user = user;
    }

}
