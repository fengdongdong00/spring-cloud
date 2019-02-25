package com.example.serviceprovider.controller;


import com.example.serviceapi.domain.User;
import com.example.serviceapi.servcie.UserClient;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fengdongdong on 2019/2/18
 */
@RestController
public class TestController implements UserClient {
    @Override
    public User getUser(String name) {
        User user = new User();
        user.setAge(10);
        user.setName("testName");
        return user;
    }

    @Override
    public void addUser(User user) {
        System.out.println(user.getName());
    }

    @Override
    public List<User> getUsersByIds(List<Long> ids) {
        List<User> list = new ArrayList<>();
        for (Long id : ids) {
            User user = new User();
            user.setName("No:" + id);
            user.setAge(1);
            list.add(user);
        }
        return list;
    }

}
