package com.example.weatherforcast.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OpenWeatherData implements Parcelable {

    @SerializedName("base")
    private String base;

    @SerializedName("visibility")
    private int visibility;

    @SerializedName("cod")
    private String cod;

    @SerializedName("timezone")
    private int timezone;

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("dt")
    private Double dt;

    @SerializedName("coord")
    private Coord coord;

    @SerializedName("weather")
    private List<Weather> weather;

    @SerializedName("main")
    private Main main;

    @SerializedName("wind")
    private Wind wind;

    @SerializedName("clouds")
    private Clouds clouds;

    @SerializedName("sys")
    private Sys2 sys;

    protected OpenWeatherData(Parcel in) {
        base = in.readString();
        visibility = in.readInt();
        cod = in.readString();
        timezone = in.readInt();
        id = in.readInt();
        name = in.readString();
        if (in.readByte() == 0) {
            dt = null;
        } else {
            dt = in.readDouble();
        }
        coord = in.readParcelable(Coord.class.getClassLoader());
        weather = in.createTypedArrayList(Weather.CREATOR);
        main = in.readParcelable(Main.class.getClassLoader());
        wind = in.readParcelable(Wind.class.getClassLoader());
        clouds = in.readParcelable(Clouds.class.getClassLoader());
    }

    public static final Creator<OpenWeatherData> CREATOR = new Creator<OpenWeatherData>() {
        @Override
        public OpenWeatherData createFromParcel(Parcel in) {
            return new OpenWeatherData(in);
        }

        @Override
        public OpenWeatherData[] newArray(int size) {
            return new OpenWeatherData[size];
        }
    };

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public int getTimezone() {
        return timezone;
    }

    public void setTimezone(int timezone) {
        this.timezone = timezone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDt() {
        return dt;
    }

    public void setDt(Double dt) {
        this.dt = dt;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Sys2 getSys() {
        return sys;
    }

    public void setSys(Sys2 sys) {
        this.sys = sys;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(base);
        parcel.writeInt(visibility);
        parcel.writeString(cod);
        parcel.writeInt(timezone);
        parcel.writeInt(id);
        parcel.writeString(name);
        if (dt == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(dt);
        }
        parcel.writeParcelable(coord, i);
        parcel.writeTypedList(weather);
        parcel.writeParcelable(main, i);
        parcel.writeParcelable(wind, i);
        parcel.writeParcelable(clouds, i);
    }
}
