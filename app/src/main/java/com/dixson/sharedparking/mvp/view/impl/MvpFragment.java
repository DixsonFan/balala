package com.dixson.sharedparking.mvp.view.impl;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.dixson.sharedparking.mvp.presenter.impl.MvpBasePresenter;
import com.dixson.sharedparking.mvp.view.MvpView;

public abstract class MvpFragment<P extends MvpBasePresenter> extends Fragment implements MvpView {


    protected  P presenter;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        presenter = bindPresenter();
        if (presenter != null)
        {
            presenter.attachView(this);
        }
    }

    //绑定
    public abstract P bindPresenter();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null)
        {
            presenter.detachView(this);
        }
    }
}
