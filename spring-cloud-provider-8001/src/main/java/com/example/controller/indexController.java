package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.domain.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class indexController {
    @Autowired
    private UserService userService;
    @Autowired
    private DiscoveryClient client;

    @GetMapping("/user/{id}")
    public User getUserBy(@PathVariable("id") Integer id) {
        return userService.getUserBy(id);
    }

    @GetMapping("/users")
    public List<User> getUserList() {
        return userService.getUserList();
    }

    @PostMapping("/user")
    public Integer addUser(@RequestBody String userJson) {
        User user = JSONObject.parseObject(userJson, User.class);
        return userService.addUser(user);
    }

    @GetMapping("/getInstance")
    public Object discovery() {
        List<String> services = client.getServices();
        for (String service : services) {
            System.out.println(service);
        }
        List<ServiceInstance> instances = client.getInstances("sp");
        for (ServiceInstance info : instances) {
            System.out.println(info);
        }
        return  this.client;
    }
}
