package com.example.mit.volley.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.support.v4.app.FragmentActivity;

import com.example.mit.volley.models.Datum;
import com.example.mit.volley.network.ApiCallRepository;

import java.util.List;

public class PlansViewModel extends ViewModel {

    private static MutableLiveData<List<Datum>> dataLiveData;
    private static PlansViewModel plansViewModel;

    public static PlansViewModel initViewmodel(FragmentActivity activity){
        if (plansViewModel==null) {
            plansViewModel= ViewModelProviders.of(activity).get(PlansViewModel.class);
        }
        return plansViewModel;
    }

    public static MutableLiveData<List<Datum>> getDataLiveData() {
        if (dataLiveData==null){
            dataLiveData=new MutableLiveData<>();
        }
        return dataLiveData;
    }


    public static void GetPlanApiCall(Context context,String uid){
        ApiCallRepository.getPlansDetails(context,uid);
    }


}
