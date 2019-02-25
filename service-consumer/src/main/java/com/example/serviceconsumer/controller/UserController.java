package com.example.serviceconsumer.controller;

import com.example.serviceapi.domain.User;
import com.example.serviceconsumer.service.UserRpcClient;
import feign.Feign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fengdongdong on 2019/2/19
 */
@RestController
public class UserController {
    @Autowired
    private UserRpcClient userRpcClient;


    @RequestMapping("/getUser")
    public User getUser() {
        return userRpcClient.getUser("dongodng");
    }

    @GetMapping("/get")
    public String get() {
        User user = new User();
        user.setName("wo heloo");
        userRpcClient.addUser(user);
        return "hahah";
    }

    @GetMapping("/getList")
    public String getList() {
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        List<User> userList = userRpcClient.getUsersByIds(ids);
        System.out.println(userList.size());
        return "hahah";
    }

}
