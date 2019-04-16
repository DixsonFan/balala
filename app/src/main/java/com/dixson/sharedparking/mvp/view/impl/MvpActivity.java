package com.dixson.sharedparking.mvp.view.impl;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.dixson.sharedparking.mvp.presenter.impl.MvpBasePresenter;
import com.dixson.sharedparking.mvp.view.MvpView;


//把架构继承到activity中

public abstract class MvpActivity<P extends MvpBasePresenter> extends AppCompatActivity implements MvpView{
    //mvp架构P是动态的
    protected P presenter;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = bindPresenter();

        if (presenter != null)
        {
            presenter.attachView(this);
        }
    }


    public abstract  P bindPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (presenter != null){

            presenter.detachView(this);
        }
    }
}
