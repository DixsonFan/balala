package com.dixson.sharedparking.sharedparking.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dixson.sharedparking.mvp.presenter.impl.MvpBasePresenter;
import com.dixson.sharedparking.mvp.view.impl.MvpFragment;

public abstract class BaseFragment<P extends MvpBasePresenter> extends MvpFragment {

    //

    private View viewContent;
    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        if(viewContent == null)
        {
            viewContent = inflater.inflate(getContentView(),container,false);
            initContentView(viewContent);

        }

        //判断是否存在fragment对应的Acticity是否存在这个视图
        ViewGroup parent = (ViewGroup) viewContent.getParent();
        //如果存在就删除重新添加
        if (parent != null){
            parent.removeView(viewContent);
        }
        return viewContent;
    }


    public P bindPresenter(){
        return null;
    }
    public  abstract  int getContentView();
    public  abstract  void initContentView(View viewContent);

}
