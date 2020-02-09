
package com.example.mysofra.data.model.editProfileClient;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EditProfileClientData {

    @SerializedName("user")
    @Expose
    private EditProfileClientUser user;

    public EditProfileClientUser getUser() {
        return user;
    }

    public void setUser(EditProfileClientUser user) {
        this.user = user;
    }

}
