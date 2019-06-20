package com.example.weatherforcast.repository;

import com.example.weatherforcast.constants.Constants;
import com.example.weatherforcast.model.WeatherData;
import com.example.weatherforcast.network.ApiClient;
import com.example.weatherforcast.network.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RemoteDataSource implements DataSource {


    private static RemoteDataSource INSTANCE;
    private ApiInterface apiInterface;

    public RemoteDataSource() {
        this.apiInterface = ApiClient.getRetrofitInstance().create(ApiInterface.class);
    }

    public static RemoteDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RemoteDataSource();
        }
        return INSTANCE;

    }

    @Override
    public void getWeatherData(String city, String appId, final LoadWeatherDataCallBack callBack) {
        apiInterface.getWeatherData(city, appId).enqueue(new Callback<WeatherData>() {
            @Override
            public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
                callBack.onWeatherDataLoaded(response.body());
            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable t) {
                callBack.onError(t.getMessage());
            }
        });

    }
}
