
package com.example.mysofra.data.model.cityAndRegion;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class cityAndRegionData {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("city_id")
    @Expose
    private String cityId;
    @SerializedName("city")
    @Expose
    private cityAndRegionData city;


    public cityAndRegionData(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public cityAndRegionData(){

    }
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public cityAndRegionData getCity() {
        return city;
    }

    public void setCity(cityAndRegionData city) {
        this.city = city;
    }

}
