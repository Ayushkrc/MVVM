package com.training.mvvmretro.viewmodel;



import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.training.mvvmretro.model.DetailModel;
import com.training.mvvmretro.network.APIService;
import com.training.mvvmretro.network.RetroInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailListViewModel extends ViewModel {

    private MutableLiveData<List<DetailModel>> detailList;

    public DetailListViewModel(){
        detailList = new MutableLiveData<>();
    }

    public MutableLiveData<List<DetailModel>> getDetailListObserver(){
        return detailList;
    }

    public void makeApiCall(){
        APIService apiService = RetroInstance.getRetroClient().create(APIService.class);
        Call<List<DetailModel>> call = apiService.getDetailList();
        call.enqueue(new Callback<List<DetailModel>>() {
            @Override
            public void onResponse(Call<List<DetailModel>> call, Response<List<DetailModel>> response) {
                detailList.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<DetailModel>> call, Throwable t) {

                detailList.postValue(null);
            }
        });
    }
}
