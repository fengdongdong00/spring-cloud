package com.example.serviceapi.servcie;


import com.example.serviceapi.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by fengdongdong on 2019/2/18
 */
@FeignClient("server-provider-eureka")
public interface UserClient {
    @GetMapping("/getUser")
    User getUser(@RequestParam("name") String name);

    @PostMapping("/addUser")
    void addUser(@RequestBody User user);

    @PostMapping("/getUsersByIds")
    List<User> getUsersByIds(@RequestBody List<Long> ids);
}
