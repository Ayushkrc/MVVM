package com.training.mvvmretro.network;

import com.training.mvvmretro.model.DetailModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    @GET("users")
    Call<List<DetailModel>> getDetailList();
}
