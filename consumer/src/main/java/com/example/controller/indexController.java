package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.config.Client;
import com.example.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class indexController {

    private static  final  String Rest_Url_Prefix="http://sp";
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private Client Spclient; //注入客户端
    @Autowired
    private DiscoveryClient client;
    @GetMapping("/users")
    List<User> getUsers() {
        List<User> map = Spclient.getUsers();
        //List<User> map = restTemplate.getForObject(Rest_Url_Prefix + "/users", List.class);
        return map;
    }

    @GetMapping("/user/{id}")
    User getUserById(@PathVariable("id") Integer id) {
        User map = Spclient.getUserById(id);
        //User map = restTemplate.getForObject(Rest_Url_Prefix + "/user/"+id, User.class);
        return  map;
    }

    @PostMapping("/user")
    String addUser(@RequestBody String userJson) {
        Integer map = Spclient.addUser(userJson);
       // User user=JSONObject.parseObject(userJson,User.class);
        //Integer map = restTemplate.postForObject(Rest_Url_Prefix + "/user",user, Integer.class);
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
