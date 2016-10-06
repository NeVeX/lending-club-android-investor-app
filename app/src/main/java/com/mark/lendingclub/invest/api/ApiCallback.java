package com.mark.lendingclub.invest.api;

/**
 * Created by NeVeX on 9/24/2015.
 */
public interface ApiCallback<T> {

    void onApiResponse(T data);
}
