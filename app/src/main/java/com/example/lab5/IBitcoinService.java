package com.example.lab5;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface IBitcoinService {
    @GET
    Call<String> getBitcoinRatesResponse(@Url String url);
}
