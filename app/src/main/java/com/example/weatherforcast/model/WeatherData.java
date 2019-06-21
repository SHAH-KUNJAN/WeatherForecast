package com.example.weatherforcast.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Parcelable {

    @SerializedName("cod")
    private String cod;

    @SerializedName("message")
    private double message;

    @SerializedName("cnt")
    private Double cnt;

    @SerializedName("list")
    private List<WeatherList> list = new ArrayList<>();

    @SerializedName("city")
    private City city;


    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public double getMessage() {
        return message;
    }

    public void setMessage(double message) {
        this.message = message;
    }

    public Double getCnt() {
        return cnt;
    }

    public void setCnt(Double cnt) {
        this.cnt = cnt;
    }

    public List<WeatherList> getList() {
        return list;
    }

    public void setList(List<WeatherList> list) {
        this.list = list;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.cod);
        dest.writeDouble(this.message);
        dest.writeValue(this.cnt);
        dest.writeTypedList(this.list);
        dest.writeParcelable(this.city, flags);
    }

    public WeatherData() {
    }

    protected WeatherData(Parcel in) {
        this.cod = in.readString();
        this.message = in.readDouble();
        this.cnt = (Double) in.readValue(Double.class.getClassLoader());
        this.list = in.createTypedArrayList(WeatherList.CREATOR);
        this.city = in.readParcelable(City.class.getClassLoader());
    }

    public static final Parcelable.Creator<WeatherData> CREATOR = new Parcelable.Creator<WeatherData>() {
        @Override
        public WeatherData createFromParcel(Parcel source) {
            return new WeatherData(source);
        }

        @Override
        public WeatherData[] newArray(int size) {
            return new WeatherData[size];
        }
    };
}
