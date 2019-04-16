package com.dixson.sharedparking.http.impl;

import com.dixson.sharedparking.http.IHTTPCommand;
import com.dixson.sharedparking.http.IRequestParam;
import com.dixson.sharedparking.http.utils.HttpUtils;

import java.util.HashMap;

public class SystemHttpCommand implements IHTTPCommand<HashMap<String,Object>> {


    @Override
    public String execute(String url, IRequestParam<HashMap<String, Object>> requestParam) {

        try {
            return HttpUtils.post(url,requestParam.getRequestParam());
        }catch (Exception e){
            e.printStackTrace();

            return null;
        }




    }
}
