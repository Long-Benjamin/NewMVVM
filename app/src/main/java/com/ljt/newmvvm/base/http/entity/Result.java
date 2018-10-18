package com.ljt.newmvvm.base.http.entity;

import android.support.annotation.Keep;

@Keep
public abstract class Result<T> {

    public static final String SUCCESS = "200";

    public abstract String getCode();

    public abstract String getMessage();

    public abstract T getData();

    public boolean isSuccess() {
        return SUCCESS.equals(getCode());
    }

}
