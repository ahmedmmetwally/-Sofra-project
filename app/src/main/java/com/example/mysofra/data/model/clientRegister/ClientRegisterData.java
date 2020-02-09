
package com.example.mysofra.data.model.clientRegister;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClientRegisterData {

    @SerializedName("api_token")
    @Expose
    private String apiToken;
    @SerializedName("user")
    @Expose
    private ClientRegisterUser user;

    public String getApiToken() {
        return apiToken;
    }

    public void setApiToken(String apiToken) {
        this.apiToken = apiToken;
    }

    public ClientRegisterUser getUser() {
        return user;
    }

    public void setUser(ClientRegisterUser user) {
        this.user = user;
    }

}
