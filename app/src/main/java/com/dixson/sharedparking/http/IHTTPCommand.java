package com.dixson.sharedparking.http;


//执行网络请求命令
public interface IHTTPCommand<T> {

    public  String execute(String url,IRequestParam<T> requestParam);
}
