package com.dixson.sharedparking.http.impl;

import com.dixson.sharedparking.http.IRequestParam;

import java.util.HashMap;

public class RequestParam implements IRequestParam<HashMap<String,Object>>{

    private HashMap<String,Object> paramMap = new HashMap<>();

    @Override
    public void put(String key, Object value) {
        paramMap.put(key,value);
    }

    @Override
    public Object get(String key) {
        return paramMap.get(key);
    }

    @Override
    public int size() {
        return paramMap.size();
    }

    @Override
    public HashMap<String, Object> getRequestParam() {
        return paramMap;
    }
}
