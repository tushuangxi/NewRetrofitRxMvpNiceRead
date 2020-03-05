package com.otherhshe.niceread.rerxmvp.presenter;

import com.otherhshe.niceread.http.SplashService;
import com.otherhshe.niceread.entity.SplashData;
import com.otherhshe.niceread.http.manager.ApiService;
import com.otherhshe.niceread.http.rx.RxManager;
import com.otherhshe.niceread.http.rx.RxSubscriber;
import com.otherhshe.niceread.rerxmvp.base.BasePresenter;
import com.otherhshe.niceread.rerxmvp.interfaceUtils.interfaceUtilsAll;

/**
 * Author: Othershe
 * Time:  2016/8/11 11:26
 */
public class SplashPresenter extends BasePresenter<interfaceUtilsAll.SplashView> {

    public SplashPresenter(interfaceUtilsAll.SplashView view) {
        super(view);
    }

    public void getSplashPic() {
        mSubscription = RxManager.getInstance()
                .doSubscribe(ApiService.getInstance().initService(SplashService.class,SplashService.BASE_URL_GET_SPLASH_PIC).getSplashPic(),
                        new RxSubscriber<SplashData>(false) {
                            @Override
                            protected void _onNext(SplashData data) {
                                mView.onSuccess(data);
                            }

                            @Override
                            protected void _onError() {
                                mView.onError();
                            }
                        });
    }
}
