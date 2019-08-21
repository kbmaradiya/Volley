package com.example.mit.volley.network;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class NetWorkRequestQueue {


    private static RequestQueue queue;

    public static RequestQueue getRequestQueue(Context context){

        if (queue==null){
            queue= Volley.newRequestQueue(context);
        }

        return queue;
    }

}
