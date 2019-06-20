package com.example.weatherforcast.repository;


public class WeatherDataRepository implements DataSource {

    private static WeatherDataRepository INSTANCE = null;
    private final DataSource mDataSource;


    public WeatherDataRepository(DataSource mDataSource) {
        this.mDataSource = mDataSource;
    }

    public static WeatherDataRepository getINSTANCE(DataSource dataSource) {
        if (INSTANCE == null) {
            synchronized (WeatherDataRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new WeatherDataRepository(dataSource);
                }
            }
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }


    @Override
    public void getWeatherData(String city, String appId, final LoadWeatherDataCallBack callBack) {
        mDataSource.getWeatherData(city, appId, callBack);
    }
}
