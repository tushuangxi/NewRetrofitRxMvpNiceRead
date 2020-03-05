package com.otherhshe.niceread.rerxmvp.interfaceUtils;

import com.otherhshe.niceread.entity.GankItemData;
import com.otherhshe.niceread.entity.GirlItemData;
import com.otherhshe.niceread.entity.SplashData;

import java.util.List;

public class interfaceUtilsAll {

    public interface IBaseView {
        void onError();
    }


    public interface GankItemView extends IBaseView {
        void onSuccess(List<GankItemData> data);
    }

    public interface GirlDetailView extends IBaseView {
        void onSuccess(List<String> data);
    }
    public interface GirlItemView extends IBaseView{
        void onSuccess(List<GirlItemData> data);
    }

    public interface SplashView extends IBaseView {
        void onSuccess(SplashData data);
    }

}
