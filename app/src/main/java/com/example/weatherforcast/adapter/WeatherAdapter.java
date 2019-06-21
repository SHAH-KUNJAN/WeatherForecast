package com.example.weatherforcast.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.weatherforcast.R;
import com.example.weatherforcast.constants.Constants;
import com.example.weatherforcast.model.WeatherList;
import com.example.weatherforcast.view.TempratureActivity;

import java.text.ParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {

    private List<WeatherList> mWeatherList;
    private Context mcontext;
    private Set<String> mSet = new HashSet<>();

    public WeatherAdapter(List<WeatherList> WeatherList, Context context) {
        this.mWeatherList = WeatherList;
        this.mcontext = context;
    }


    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_5_day_temp, viewGroup, false);
        return new WeatherViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder holder, int i) {
        WeatherList weatherList = mWeatherList.get(i);
        if (!mSet.contains(weatherList.getDtTxt())) {

            mSet.add(weatherList.getDtTxt());

            if (weatherList.getDtTxt() != null) {
                try {
                    String s = TempratureActivity.dayOfTheWeek(weatherList.getDtTxt());
                    holder.mDay.setText(s);
                    holder.mDate.setText(weatherList.getDtTxt());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

            if (weatherList.getClouds() != null) {
                holder.mclouds.setText(weatherList.getClouds().getAll() + "%");
            }

            if (weatherList.getWind() != null) {
                holder.mwindspeed.setText(weatherList.getWind().getSpeed() + "km/h");
            }

            if (weatherList.getWeather().get(0).getDescription() != null) {
                holder.mdescription.setText(weatherList.getWeather().get(0).getDescription());
            }
            if (weatherList.getWeather().get(0).getIcon() != null) {
                String icon = mWeatherList.get(0).getWeather().get(0).getIcon();
                Glide.with(mcontext)
                        .load(Constants.IMAGE_URL + icon + Constants.PNG)
                        .into(holder.mImg);
            }

            String temp = weatherList.getMain().getTempMin() + "/" + weatherList.getMain().getTempMax();
            holder.mtempMinMax.setText(temp);

        }


    }

    @Override
    public int getItemCount() {
        return mWeatherList.size();
    }

    public class WeatherViewHolder extends RecyclerView.ViewHolder {

        private TextView mDay, mDate, mclouds, mwindspeed, mdescription, mtempMinMax;
        private ImageView mImg;

        public WeatherViewHolder(@NonNull View itemView) {
            super(itemView);
            mDay = itemView.findViewById(R.id.dayName);
            mDate = itemView.findViewById(R.id.date);
            mclouds = itemView.findViewById(R.id.clouds);
            mwindspeed = itemView.findViewById(R.id.windspeed);
            mdescription = itemView.findViewById(R.id.description);
            mtempMinMax = itemView.findViewById(R.id.tempMinMax);
            mImg = itemView.findViewById(R.id.ImgView);
        }
    }
}
