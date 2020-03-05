package com.otherhshe.niceread.http.manager;

public class ApiService {
    public static ApiService getInstance() {
        return ApiService.SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final ApiService INSTANCE = new ApiService();
    }

    public <S> S initService(Class<S> service,String baseUrl) {
        return NetManager.getInstance().create(service, baseUrl);
//        return NetManager.getInstance().create1(service, baseUrl);
    }
}
