package com.example.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView tvMain;
    ListView ratesListView;
    ArrayList<String> ratesList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ratesListView = findViewById(R.id.rates_listView);
        tvMain = findViewById(R.id.cryptocurrency_rates_textView);
        ratesList = new ArrayList<>();

        ratesList.add("BTC - 19000 USD");
        ratesList.add("ETH - 1300 USD");
        ratesList.add("BNB - 270 USD");

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ratesList);
        ratesListView.setAdapter(adapter);

        RetrofitDataLoader rt = new RetrofitDataLoader();
        rt.getData(getApplicationContext());
    }
}