package com.example.weatherforcast.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class rain implements Parcelable {

    @SerializedName("3h")
    private double h3;

    protected rain(Parcel in) {
        h3 = in.readDouble();
    }

    public static final Parcelable.Creator<rain> CREATOR = new Parcelable.Creator<rain>() {
        @Override
        public rain createFromParcel(Parcel in) {
            return new rain(in);
        }

        @Override
        public rain[] newArray(int size) {
            return new rain[size];
        }
    };

    public double getH3() {
        return h3;
    }

    public void setH3(double h3) {
        this.h3 = h3;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(h3);
    }
}
