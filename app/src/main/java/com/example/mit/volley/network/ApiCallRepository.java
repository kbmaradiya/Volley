package com.example.mit.volley.network;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.mit.volley.models.Plans;
import com.example.mit.volley.viewmodels.PlansViewModel;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class ApiCallRepository {


    private static final String PLANS_URL = "YOUR_URL";

    public static void getPlansDetails(Context context, final String uid) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, PLANS_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Log.e("ApiCallRepository","response : "+response.toString());

                        Gson gson = new Gson();
                        Plans plans= gson.fromJson(response, Plans.class);
                        if (plans.getCode()==1){
                            PlansViewModel.getDataLiveData().setValue(plans.getData());
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.e("ApiCallRepository","error : "+error.getMessage());
            }

        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                return Params.getPlansParams(uid);
            }
        };


        NetWorkRequestQueue.getRequestQueue(context).add(stringRequest);
    }

}
