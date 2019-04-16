package com.dixson.sharedparking.http;

public interface IRequestParam<T> {
    public void put (String key,Object value);

    public Object get (String key);

    public int size();

    public T getRequestParam();
}
