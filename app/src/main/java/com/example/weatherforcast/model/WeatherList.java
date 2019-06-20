package com.example.weatherforcast.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherList implements Parcelable {

    @SerializedName("main")
    private Main main;

    @SerializedName("weather")
    private List<Weather> weather;

    @SerializedName("clouds")
    private Clouds clouds;

    @SerializedName("wind")
    private Wind wind;

    @SerializedName("rain")
    private rain rain;

    @SerializedName("sys")
    private Sys sys;

    @SerializedName("dt_txt")
    private String dtTxt;


    protected WeatherList(Parcel in) {
        dtTxt = in.readString();
        weather = in.createTypedArrayList(Weather.CREATOR);
        main = in.readParcelable(Main.class.getClassLoader());
        clouds = in.readParcelable(Clouds.class.getClassLoader());
        wind = in.readParcelable(Wind.class.getClassLoader());
        rain = in.readParcelable(rain.class.getClassLoader());
        sys = in.readParcelable(Sys.class.getClassLoader());

    }

    public static final Parcelable.Creator<WeatherList> CREATOR = new Parcelable.Creator<WeatherList>() {
        @Override
        public WeatherList createFromParcel(Parcel in) {
            return new WeatherList(in);
        }

        @Override
        public WeatherList[] newArray(int size) {
            return new WeatherList[size];
        }
    };

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public rain getRain() {
        return rain;
    }

    public void setRain(rain rain) {
        this.rain = rain;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public String getDtTxt() {
        return dtTxt;
    }

    public void setDtTxt(String dtTxt) {
        this.dtTxt = dtTxt;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(dtTxt);
        parcel.writeParcelable(this.clouds, i);
        parcel.writeParcelable(this.main, i);
        parcel.writeParcelable(this.rain, i);
        parcel.writeParcelable(this.sys, i);
        parcel.writeParcelable(this.wind, i);
        parcel.writeTypedList(this.weather);

    }
}
