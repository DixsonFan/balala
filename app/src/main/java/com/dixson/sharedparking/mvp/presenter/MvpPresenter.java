package com.dixson.sharedparking.mvp.presenter;

import com.dixson.sharedparking.mvp.view.MvpView;

public interface MvpPresenter<V extends MvpView> extends MvpView {

    //绑定
    public void  attachView(V view);
    //解除绑定
    public void detachView(V view);
}
