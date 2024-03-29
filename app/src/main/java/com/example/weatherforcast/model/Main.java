package com.example.weatherforcast.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Main implements Parcelable {

    @SerializedName("temp")
    private double temp;

    @SerializedName("temp_min")
    private double tempMin;

    @SerializedName("temp_max")
    private double tempMax;

    @SerializedName("pressure")
    private double pressure;

    @SerializedName("sea_level")
    private double seaLevel;

    @SerializedName("grnd_level")
    private double grndLevel;

    @SerializedName("humidity")
    private double humidity;

    @SerializedName("temp_kf")
    private double tempKf;



    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getTempMin() {
        return tempMin;
    }

    public void setTempMin(double tempMin) {
        this.tempMin = tempMin;
    }

    public double getTempMax() {
        return tempMax;
    }

    public void setTempMax(double tempMax) {
        this.tempMax = tempMax;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getSeaLevel() {
        return seaLevel;
    }

    public void setSeaLevel(double seaLevel) {
        this.seaLevel = seaLevel;
    }

    public double getGrndLevel() {
        return grndLevel;
    }

    public void setGrndLevel(double grndLevel) {
        this.grndLevel = grndLevel;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getTempKf() {
        return tempKf;
    }

    public void setTempKf(double tempKf) {
        this.tempKf = tempKf;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(this.temp);
        dest.writeDouble(this.tempMin);
        dest.writeDouble(this.tempMax);
        dest.writeDouble(this.pressure);
        dest.writeDouble(this.seaLevel);
        dest.writeDouble(this.grndLevel);
        dest.writeDouble(this.humidity);
        dest.writeDouble(this.tempKf);
    }

    public Main() {
    }

    protected Main(Parcel in) {
        this.temp = in.readDouble();
        this.tempMin = in.readDouble();
        this.tempMax = in.readDouble();
        this.pressure = in.readDouble();
        this.seaLevel = in.readDouble();
        this.grndLevel = in.readDouble();
        this.humidity = in.readDouble();
        this.tempKf = in.readDouble();
    }

    public static final Parcelable.Creator<Main> CREATOR = new Parcelable.Creator<Main>() {
        @Override
        public Main createFromParcel(Parcel source) {
            return new Main(source);
        }

        @Override
        public Main[] newArray(int size) {
            return new Main[size];
        }
    };
}
