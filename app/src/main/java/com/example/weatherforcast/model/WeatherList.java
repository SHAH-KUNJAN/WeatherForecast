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
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.main, flags);
        dest.writeTypedList(this.weather);
        dest.writeParcelable(this.clouds, flags);
        dest.writeParcelable(this.wind, flags);
        dest.writeParcelable(this.rain, flags);
        dest.writeParcelable(this.sys, flags);
        dest.writeString(this.dtTxt);
    }

    public WeatherList() {
    }

    protected WeatherList(Parcel in) {
        this.main = in.readParcelable(Main.class.getClassLoader());
        this.weather = in.createTypedArrayList(Weather.CREATOR);
        this.clouds = in.readParcelable(Clouds.class.getClassLoader());
        this.wind = in.readParcelable(Wind.class.getClassLoader());
        this.rain = in.readParcelable(com.example.weatherforcast.model.rain.class.getClassLoader());
        this.sys = in.readParcelable(Sys.class.getClassLoader());
        this.dtTxt = in.readString();
    }

    public static final Parcelable.Creator<WeatherList> CREATOR = new Parcelable.Creator<WeatherList>() {
        @Override
        public WeatherList createFromParcel(Parcel source) {
            return new WeatherList(source);
        }

        @Override
        public WeatherList[] newArray(int size) {
            return new WeatherList[size];
        }
    };
}
