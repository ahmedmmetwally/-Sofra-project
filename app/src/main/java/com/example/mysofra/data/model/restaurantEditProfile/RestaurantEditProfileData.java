
package com.example.mysofra.data.model.restaurantEditProfile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RestaurantEditProfileData {

    @SerializedName("user")
    @Expose
    private RestaurantEditProfileUser user;

    public RestaurantEditProfileUser getUser() {
        return user;
    }

    public void setUser(RestaurantEditProfileUser user) {
        this.user = user;
    }

}
