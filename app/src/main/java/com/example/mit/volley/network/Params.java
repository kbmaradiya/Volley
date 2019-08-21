package com.example.mit.volley.network;

import java.util.HashMap;
import java.util.Map;

public class Params {

    public static HashMap<String,String> getPlansParams(String uid){
        HashMap<String,String> params=new HashMap<>();
        params.put("user_id",uid);
        return params;
    }
}
