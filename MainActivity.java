package com.training.mvvmretro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.training.mvvmretro.adapter.DetailListAdapter;
import com.training.mvvmretro.model.DetailModel;
import com.training.mvvmretro.viewmodel.DetailListViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<DetailModel> detailModelList;
    private DetailListAdapter adapter;
    private DetailListViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        final TextView noresult = findViewById(R.id.noResultTv);
        LinearLayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new DetailListAdapter(this,detailModelList);
        recyclerView.setAdapter(adapter);

        viewModel = ViewModelProviders.of(this).get(DetailListViewModel.class);
        viewModel.getDetailListObserver().observe(this, new Observer<List<DetailModel>>() {
            @Override
            public void onChanged(List<DetailModel> detailModels) {
                if (detailModels != null){
                    detailModelList = detailModels;
                    adapter.setDetailList(detailModels);
                    noresult.setVisibility(View.GONE);
                } else {
                    noresult.setVisibility(View.VISIBLE);
                }
            }
        });

        viewModel.makeApiCall();

    }
}