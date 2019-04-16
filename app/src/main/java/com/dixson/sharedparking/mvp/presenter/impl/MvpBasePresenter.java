package com.dixson.sharedparking.mvp.presenter.impl;

import android.view.View;

import com.dixson.sharedparking.mvp.presenter.MvpPresenter;
import com.dixson.sharedparking.mvp.view.MvpView;

public abstract class MvpBasePresenter <V extends MvpView> implements MvpPresenter<V> {


    private V view;

    @Override
    public void attachView(V view) {

    }

    @Override
    public void detachView(V view) {

        if (view != null)
        {
            view = null;
        }

    }
}
