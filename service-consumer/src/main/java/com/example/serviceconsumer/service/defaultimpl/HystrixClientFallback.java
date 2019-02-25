package com.example.serviceconsumer.service.defaultimpl;

import com.example.serviceapi.domain.User;
import com.example.serviceconsumer.service.UserRpcClient;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fengdongdong on 2019/2/21
 */
@Service
public class HystrixClientFallback implements UserRpcClient {
    @Override
    public User getUser(String name) {
        User user = new User();
        user.setName("我熔断了");
        return user;
    }

    @Override
    public void addUser(User user) {
        System.out.println("异常");
    }

    @Override
    public List<User> getUsersByIds(List<Long> ids) {
        return null;
    }
}
