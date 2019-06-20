package com.example.weatherforcast.repository;

import com.example.weatherforcast.model.WeatherData;

public interface DataSource {

    interface LoadWeatherDataCallBack{
        void onWeatherDataLoaded(WeatherData weatherData);
        void onDataNotAvailable();
        void onError(String message);
    }

    void getWeatherData(String city,String appId,LoadWeatherDataCallBack callBack);
}
