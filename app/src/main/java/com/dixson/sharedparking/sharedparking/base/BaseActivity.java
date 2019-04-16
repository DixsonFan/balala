package com.dixson.sharedparking.sharedparking.base;

import com.dixson.sharedparking.mvp.presenter.impl.MvpBasePresenter;
import com.dixson.sharedparking.mvp.view.impl.MvpActivity;

public abstract class BaseActivity<P extends MvpBasePresenter> extends MvpActivity<P> {
}
