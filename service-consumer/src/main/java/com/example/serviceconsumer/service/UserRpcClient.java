package com.example.serviceconsumer.service;

import com.example.serviceapi.servcie.UserClient;
import com.example.serviceconsumer.service.defaultimpl.HystrixClientFallback;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * Created by fengdongdong on 2019/2/19
 */
@FeignClient(name = "${spring.application.name.user.service}",fallback = HystrixClientFallback.class,url = "127.0.0.1:8003",path = "server-provider-eureka")
public interface UserRpcClient extends UserClient {
}
