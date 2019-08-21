package com.example.mit.volley.repositories;

import android.content.Context;

import com.example.mit.volley.network.ApiCallRepository;

public class PlansRepository {


    public static void getPlansDetails(Context context){
        ApiCallRepository.getPlansDetails(context,"870");
    }
}
