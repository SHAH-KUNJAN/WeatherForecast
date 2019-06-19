package com.example.weatherforcast.model;

import com.google.gson.annotations.SerializedName;

public class rain {

    @SerializedName("3h")
    private double h3;

    public double getH3() {
        return h3;
    }

    public void setH3(double h3) {
        this.h3 = h3;
    }
}
