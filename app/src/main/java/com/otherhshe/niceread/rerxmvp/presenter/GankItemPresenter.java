package com.otherhshe.niceread.rerxmvp.presenter;

import com.otherhshe.niceread.http.SplashService;
import com.otherhshe.niceread.entity.GankItemData;
import com.otherhshe.niceread.http.manager.ApiService;
import com.otherhshe.niceread.http.rx.RxManager;
import com.otherhshe.niceread.http.rx.RxSubscriber;
import com.otherhshe.niceread.rerxmvp.base.BasePresenter;
import com.otherhshe.niceread.rerxmvp.interfaceUtils.interfaceUtilsAll;

import java.util.List;


/**
 * Author: Othershe
 * Time: 2016/8/12 14:29
 */
public class GankItemPresenter extends BasePresenter<interfaceUtilsAll.GankItemView> {
    public GankItemPresenter(interfaceUtilsAll.GankItemView view) {
        super(view);
    }

    public void getGankItemData(String suburl) {
        mSubscription = RxManager.getInstance()
                .doSubscribe1(ApiService.getInstance().initService(SplashService.class,SplashService.BASE_URL_GET_GANK).getGankItemData(suburl),
                        new RxSubscriber<List<GankItemData>>(true) {
                            @Override
                            protected void _onNext(List<GankItemData> gankItemData) {
                                mView.onSuccess(gankItemData);
                            }

                            @Override
                            protected void _onError(Throwable e) {
                                mView.onError();
                            }
                        });
    }
}
