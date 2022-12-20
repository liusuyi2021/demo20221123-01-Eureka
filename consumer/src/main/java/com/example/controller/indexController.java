package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.config.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestOperations;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class indexController {

    @Resource
    private Client Spclient; //注入客户端
    @Autowired
    private DiscoveryClient client;
    @GetMapping("/users")
    String getUsers() {
        String map = Spclient.getUsers();
        return "消费者使用生产者的接口:" + map;
    }

    @GetMapping("/user/{id}")
    String getUserById(@PathVariable("id") Integer id) {
        String map = Spclient.getUserById(id);
        return "消费者使用生产者的接口:" + map;
    }

    @PostMapping("/user")
    String addUser(@RequestBody String userJson) {
        Integer map = Spclient.addUser(userJson);
        return "消费者使用生产者的接口:" + map;
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
