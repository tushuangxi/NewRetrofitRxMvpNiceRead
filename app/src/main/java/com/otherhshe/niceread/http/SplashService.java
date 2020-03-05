package com.otherhshe.niceread.http;


import com.otherhshe.niceread.entity.GankItemData;
import com.otherhshe.niceread.entity.HttpResult;
import com.otherhshe.niceread.entity.SplashData;

import java.util.List;
import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Author: Othershe
 * Time:  2016/8/11 12:30
 */
public interface SplashService {

    String BASE_URL_GET_SPLASH_PIC = "http://news-at.zhihu.com/api/5/start-image/";
    String BASE_URL_GET_GANK = "http://gank.io/api/";
    String BASE_URL_GET_GIRL = "http://www.dbmeinv.com/dbgroup/";

    @GET("1080*1920")
    Observable<SplashData> getSplashPic();

    @GET("{id}")
    Observable<String> getGirlDetailData(@Path("id") String id);

    @GET("show.htm")
    Observable<String> getGirlItemData(@Query("cid") String cid, @Query("pager_offset") int pager_offset);

    @GET("{suburl}")
    Observable<HttpResult<List<GankItemData>>> getGankItemData(@Path("suburl") String suburl);


//    @GET("nc/article/{type}/{id}/{startPage}-20.html")
//    Observable<JsonRootBean> getNewsList(
//            @Header("Cache-Control") String cacheControl,
//            @Path("type") String type, @Path("id") String id,
//            @Path("startPage") int startPage);
//
//    //GetListRsp
//    @GET("/cats/lv2/statistics/")
//    Observable<GetListRsp> requestGetListRspList(@QueryMap Map<String, String> params);
}
