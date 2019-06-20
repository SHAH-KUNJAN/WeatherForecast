package com.example.weatherforcast.viewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.weatherforcast.constants.Constants;
import com.example.weatherforcast.model.WeatherData;
import com.example.weatherforcast.repository.DataSource;
import com.example.weatherforcast.repository.RemoteDataSource;
import com.example.weatherforcast.repository.WeatherDataRepository;

public class WeatherDataViewModel extends ViewModel {
    private MutableLiveData<WeatherData> mWeatherData = new MutableLiveData<>();
    private WeatherDataRepository mWeatherDataRepository;
    private MutableLiveData<String> mSnackbarText = new MutableLiveData<>();

    public WeatherDataViewModel() {
        this.mWeatherDataRepository = WeatherDataRepository.getINSTANCE(RemoteDataSource.getInstance());
    }

    public void loadWeatherData(String city) {
        mWeatherDataRepository.getWeatherData(city, Constants.API_KEY, new DataSource.LoadWeatherDataCallBack() {
            @Override
            public void onWeatherDataLoaded(WeatherData weatherData) {
                mWeatherData.setValue(weatherData);
            }

            @Override
            public void onDataNotAvailable() {
                mSnackbarText.postValue("No Data Available");
            }

            @Override
            public void onError(String message) {
                mSnackbarText.postValue(message);

            }
        });
    }


    public LiveData<WeatherData> getWeatherData() {
        return mWeatherData;
    }

    public LiveData<String> getSnackbarMessage() {
        return mSnackbarText;
    }
}
