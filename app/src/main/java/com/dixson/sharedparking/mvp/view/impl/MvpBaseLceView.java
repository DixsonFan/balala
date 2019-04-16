package com.dixson.sharedparking.mvp.view.impl;

public abstract class MvpBaseLceView<M> implements MvpLceView<M> {
    public MvpBaseLceView() {
        super();
    }

    @Override
    public void showLoading(boolean pullToRefesh) {

    }

    @Override
    public void showContent() {

    }

    @Override
    public void showError(Exception e, boolean pullToRefesh) {

    }

    @Override
    public void bindData(M data) {

    }
}
