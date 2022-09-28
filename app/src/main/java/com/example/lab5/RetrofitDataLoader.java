package com.example.lab5;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;


public class RetrofitDataLoader{
    public String getData(Context ctx) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(ScalarsConverterFactory.create())
                .baseUrl("https://your.base.url/")
                .build();

        IBitcoinService service = retrofit.create(IBitcoinService.class);
        Call<String> stringCall = service.getBitcoinRatesResponse("https://cdn.jsdelivr.net/gh/fawazahmed0/currency-api@1/latest/currencies/btc/usd.json");
        stringCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    Log.d("Retro", response.body());
                    Toast.makeText(ctx, response.body(), Toast.LENGTH_SHORT).show();
                    //tvMain.setText(response.body());
                }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                t.printStackTrace();

            }
        });
        return "";
    }
}
