package com.example.serviceconsumer.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * Created by fengdongdong on 2019/2/20
 */
public class MyRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        System.out.println("拦截器");
    }
}
