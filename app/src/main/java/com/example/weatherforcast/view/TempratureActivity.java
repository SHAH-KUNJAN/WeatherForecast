package com.example.weatherforcast.view;

import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.weatherforcast.R;
import com.example.weatherforcast.constants.Constants;
import com.example.weatherforcast.model.City;
import com.example.weatherforcast.model.WeatherData;
import com.example.weatherforcast.model.WeatherList;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TempratureActivity extends AppCompatActivity {

    private WeatherData mWeatherData;
    private ImageView mImageView;
    private TextView mMin, mMax, mCurrent, mCity, mDay;
    private RecyclerView mRecyclerView;
    private List<WeatherList> mWeatherList = new ArrayList<>();
    private City mCityClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temprature);

        Bundle bundle = getIntent().getExtras();
        mCityClass = bundle.getParcelable("EXTRAS_CITY");
        mWeatherList = getIntent().getParcelableArrayListExtra("EXTRAS_LIST");

        mImageView = findViewById(R.id.tempImgView);
        mMin = findViewById(R.id.tempMin);
        mMax = findViewById(R.id.tempMax);
        mCurrent = findViewById(R.id.tempcurrent);
        mCity = findViewById(R.id.tempCity);
        mDay = findViewById(R.id.tempToday);

        String icon = mWeatherList.get(0).getWeather().get(0).getIcon();
        Glide.with(this)
                .load(Constants.IMAGE_URL + icon + Constants.PNG)
                .into(mImageView);

        mMin.setText(convertToCelsius(mWeatherList.get(0).getMain().getTempMin()));
        mMax.setText(convertToCelsius(mWeatherList.get(0).getMain().getTempMax()));
        mCurrent.setText(convertToCelsius(mWeatherList.get(0).getMain().getTemp()));
        mCity.setText(mCityClass.getName());
        try {
            mDay.setText(dayOfTheWeek(mWeatherList.get(0).getDtTxt()));
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

    private String dayOfTheWeek(String date) throws ParseException {
        SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
        Date dt1 = format1.parse(date);
        DateFormat format2 = new SimpleDateFormat("EEEE");
        String dayofweek = format2.format(dt1);
        return dayofweek;
    }

    private String convertToCelsius(double d) {
        String s = String.valueOf(d);
        String[] k = s.split(".");
        return (k[0] + " \u2103");

    }

}
