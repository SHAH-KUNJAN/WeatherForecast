package com.example.weatherforcast.model;

import com.google.gson.annotations.SerializedName;

public class Sys2 {

    @SerializedName("type")
    private Integer type;

    @SerializedName("id")
    private Integer id;

    @SerializedName("message")
    private Float message;

    @SerializedName("country")
    private String country;

    @SerializedName("sunrise")
    private Integer sunrise;

    @SerializedName("sunset")
    private Integer sunset;


    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getMessage() {
        return message;
    }

    public void setMessage(Float message) {
        this.message = message;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getSunrise() {
        return sunrise;
    }

    public void setSunrise(Integer sunrise) {
        this.sunrise = sunrise;
    }

    public Integer getSunset() {
        return sunset;
    }

    public void setSunset(Integer sunset) {
        this.sunset = sunset;
    }
}
