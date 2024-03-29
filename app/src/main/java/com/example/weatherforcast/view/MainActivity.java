package com.example.weatherforcast.view;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weatherforcast.R;
import com.example.weatherforcast.model.WeatherList;
import com.example.weatherforcast.viewModel.WeatherDataViewModel;
import com.nex3z.flowlayout.FlowLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText mSearchBar;
    private FlowLayout mFlowLayout;
    private ImageView mSearchBtn;
    private List<String> mCityName = new ArrayList<>();
    private WeatherDataViewModel mWeatherDataViewModel;
    private List<WeatherList> mList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSearchBar = findViewById(R.id.etSearchBar);
        mFlowLayout = findViewById(R.id.searchFlowLayout);
        mCityName = Arrays.asList(getResources().getStringArray(R.array.popular_city));
        mSearchBtn = findViewById(R.id.searchBtn);
        setData();
        mWeatherDataViewModel = ViewModelProviders.of(this).get(WeatherDataViewModel.class);
        mSearchBtn.setOnClickListener(view -> dataSearch());
    }

    private void dataSearch() {
        String edittext = mSearchBar.getText().toString();
        if (!edittext.matches("") && !TextUtils.isEmpty(edittext)) {
            mWeatherDataViewModel.loadWeatherData(mSearchBar.getText().toString() + ",IN");
            mWeatherDataViewModel.getWeatherData().observe(this, weatherData -> {
                if (weatherData.getCod().equals("200")) {
                    mList = weatherData.getList();
                    /*Toast.makeText(this, weatherData.getCity().getName(), Toast.LENGTH_SHORT).show();*/
                    Intent intent = new Intent(MainActivity.this, TempratureActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("EXTRAS_CITY", weatherData.getCity());
                    // bundle.putParcelableArrayList("EXTRAS_LIST", (ArrayList<? extends Parcelable>) mList);
                    intent.putExtras(bundle);
                    intent.putParcelableArrayListExtra("EXTRAS_LIST", (ArrayList<? extends Parcelable>) mList);
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "city not found", Toast.LENGTH_SHORT).show();
                }
            });
            mSearchBar.setText("");
        } else {
            Toast.makeText(this, "Please Fill the SearchBar ...", Toast.LENGTH_SHORT).show();
        }

    }

    private void setData() {
        for (int i = 0; i < mCityName.size(); i++) {
            TextView mTextView = (TextView) LayoutInflater.from(this).inflate(R.layout.item_city_text, mFlowLayout, false);
            mTextView.setText(mCityName.get(i));
            mTextView.setTag(mCityName.get(i));
            mFlowLayout.addView(mTextView);
            mTextView.setOnClickListener(view -> mSearchBar.setText(view.getTag().toString()));
        }

    }
}
