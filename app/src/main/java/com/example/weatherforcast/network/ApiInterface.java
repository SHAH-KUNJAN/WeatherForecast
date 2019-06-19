package com.example.weatherforcast.network;

import com.example.weatherforcast.model.OpenWeatherData;
import com.example.weatherforcast.model.WeatherData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("forecast?units=metric")
    Call<WeatherData> getWeatherData(@Query("q") String city, @Query("appid") String appId);

    @GET("weather?units=metric")
    Call<OpenWeatherData> getOpenWeatherData(@Query("q") String city, @Query("appid") String appId);

}
