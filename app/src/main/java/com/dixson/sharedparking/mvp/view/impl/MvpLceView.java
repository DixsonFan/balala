package com.dixson.sharedparking.mvp.view.impl;

//请求数据，刷新UI界面监听

import com.dixson.sharedparking.mvp.view.MvpView;

public interface MvpLceView<M> extends MvpView{

    //显示加载中的试图，舰艇加载类型
    public void showLoading(boolean pullToRefesh);

    //显示ContentView
    public void showContent();

    //加载错误
    public void showError(Exception e,boolean pullToRefesh);

    //绑定数据
    public void bindData(M data);
}
