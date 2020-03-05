package com.otherhshe.niceread.rerxmvp.presenter;

import com.otherhshe.niceread.http.SplashService;
import com.otherhshe.niceread.http.manager.ApiService;
import com.otherhshe.niceread.http.rx.RxManager;
import com.otherhshe.niceread.http.rx.RxSubscriber;
import com.otherhshe.niceread.rerxmvp.base.BasePresenter;
import com.otherhshe.niceread.rerxmvp.interfaceUtils.interfaceUtilsAll;
import com.otherhshe.niceread.utils.JsoupUtil;

/**
 * Author: Othershe
 * Time: 2016/8/12 14:29
 */
public class GirlItemPresenter extends BasePresenter<interfaceUtilsAll.GirlItemView> {

    public GirlItemPresenter(interfaceUtilsAll.GirlItemView view) {
        super(view);
    }

    public void getGirlItemData(String cid, int page) {
        mSubscription = RxManager.getInstance()
                .doSubscribe(ApiService.getInstance().initService(SplashService.class,SplashService.BASE_URL_GET_GIRL).getGirlItemData(cid, page),
                        new RxSubscriber<String>(false) {
                            @Override
                            protected void _onNext(String s) {
                                mView.onSuccess(JsoupUtil.parseGirls(s));
                            }

                            @Override
                            protected void _onError() {
                                mView.onError();
                            }
                        });
    }
}
