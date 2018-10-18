package com.ljt.newmvvm.base.http;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.ljt.mvvmdemo.base.http.ResultMessageException;
import com.ljt.mvvmdemo.base.type.GankResult;
import com.ljt.newmvvm.base.http.entity.Result;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.LifecycleTransformer;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

public class TransformHelper {

    /**
     * 返回数据的转换
     * @param <T>
     * @param <RESULT>
     * @return
     */
    public static <T, RESULT extends Result<T>> ObservableTransformer<RESULT, T> transformResultToData() {
        return  new ObservableTransformer<RESULT, T>() {
            @Override
            public ObservableSource<T> apply(Observable<RESULT> upstream) {
                return upstream
                        .flatMap(new Function<RESULT,Observable<RESULT>>() {

                            @Override
                            public Observable<RESULT> apply(RESULT result) throws Exception {
                                String errorMessage = "";
                                //数据异常
                                if (result == null){
                                    return Observable.error(new ResultMessageException(errorMessage));

                                //服务器或数据请求异常
                                }else if (!result.isSuccess()) {
                                    errorMessage = result.getMessage();
                                    return Observable.error(new ResultMessageException(errorMessage));
                                }
                                return Observable.just(result);
                            }
                        })
                        .map(new Function<RESULT, T>() {
                            @Override
                            public T apply(RESULT result) throws Exception {
                                return result.getData();
                            }
                        });
            }

        };
    }


    /**
     * 全局捕捉异常处理
     * @param <T>
     * @param <RESULT>
     * @return
     */
    public static <T, RESULT extends GankResult<T>> ObservableTransformer<RESULT, T> transformToResult() {
        return  new ObservableTransformer<RESULT, T>() {
            @Override
            public ObservableSource<T> apply(Observable<RESULT> upstream) {
                return upstream
                        .flatMap(new Function<RESULT,Observable<RESULT>>() {

                            @Override
                            public Observable<RESULT> apply(RESULT result) throws Exception {
                                String errorMessage = "";
                                //数据异常
                                if (result == null){
                                    return Observable.error(new ResultMessageException(errorMessage));

                                //服务器或数据请求异常
                                }else if (result.getError()) {
                                    errorMessage = "当前网络不稳定或服务器响应超时！";
                                    return Observable.error(new ResultMessageException(errorMessage));
                                }
                                return Observable.just(result);
                            }
                        })
                        .map(new Function<RESULT, T>() {
                            @Override
                            public T apply(RESULT result) throws Exception {
                                return result.getResults();
                            }
                        });
            }

        };
    }


    /**
     * 生命周期绑定
     *
     * @param lifecycle Activity
     */
    public static LifecycleTransformer bindToLifecycle(@NonNull Context lifecycle) {
        if (lifecycle instanceof LifecycleProvider) {
            return ((LifecycleProvider) lifecycle).bindToLifecycle();
        } else {
            throw new IllegalArgumentException("context not the LifecycleProvider type");
        }

    }

   /**
     * 生命周期绑定
     *
     * @param lifecycle Fragment
     */
    public static <T> LifecycleTransformer bindToLifecycle(@NonNull Fragment lifecycle) {
        if (lifecycle instanceof LifecycleProvider) {
            return ((LifecycleProvider) lifecycle).bindToLifecycle();
        } else {
            throw new IllegalArgumentException("fragment not the LifecycleProvider type");
        }
    }


}
