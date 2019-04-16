package com.dixson.sharedparking.sharedparking.base;

import android.content.Context;

import com.dixson.sharedparking.mvp.model.MvpModel;

public abstract class BaseModel implements MvpModel {

    private Context context;
    public BaseModel(Context context){
        this.context = context;
    }

}
