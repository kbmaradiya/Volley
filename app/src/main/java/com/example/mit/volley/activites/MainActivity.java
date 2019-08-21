package com.example.mit.volley.activites;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.mit.volley.R;
import com.example.mit.volley.adapter.PlansAdapter;
import com.example.mit.volley.models.Datum;
import com.example.mit.volley.viewmodels.PlansViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    private PlansAdapter mAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();

        initializePlanViewModel();

        initializeRecyclerView();
    }

    private void findViews() {
        recyclerView = findViewById(R.id.recyclerView);
    }

    private void initializeRecyclerView() {

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }

    private void initializePlanViewModel() {
        PlansViewModel.initViewmodel(this);

        PlansViewModel.GetPlanApiCall(this, "870");

        PlansViewModel.getDataLiveData().observe(this, new Observer<List<Datum>>() {
            @Override
            public void onChanged(@Nullable List<Datum> data) {
                if (mAdapter != null) {
                    mAdapter.notifyDataSetChanged();
                } else {
                    mAdapter = new PlansAdapter(MainActivity.this, PlansViewModel.getDataLiveData().getValue());
                    recyclerView.setAdapter(mAdapter);
                }
            }
        });

    }

}
