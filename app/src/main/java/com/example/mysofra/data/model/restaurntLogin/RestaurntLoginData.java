
package com.example.mysofra.data.model.restaurntLogin;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RestaurntLoginData {

    @SerializedName("api_token")
    @Expose
    private String apiToken;
    @SerializedName("user")
    @Expose
    private RestaurntLoginUser user;

    public String getApiToken() {
        return apiToken;
    }

    public void setApiToken(String apiToken) {
        this.apiToken = apiToken;
    }

    public RestaurntLoginUser getUser() {
        return user;
    }

    public void setUser(RestaurntLoginUser user) {
        this.user = user;
    }

}
