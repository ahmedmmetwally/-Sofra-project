
package com.example.mysofra.data.model.restaurntreviewe;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RestaurntRevieweDatum {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("comment")
    @Expose
    private String comment;
    @SerializedName("rate")
    @Expose
    private Float rate;
    @SerializedName("restaurant_id")
    @Expose
    private String restaurantId;
    @SerializedName("client_id")
    @Expose
    private String clientId;
    @SerializedName("client")
    @Expose
    private RestaurntRevieweClient client;
    @SerializedName("restaurant")
    @Expose
    private RestaurntRevieweRestaurant restaurant;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public RestaurntRevieweClient getClient() {
        return client;
    }

    public void setClient(RestaurntRevieweClient client) {
        this.client = client;
    }

    public RestaurntRevieweRestaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(RestaurntRevieweRestaurant restaurant) {
        this.restaurant = restaurant;
    }

}
