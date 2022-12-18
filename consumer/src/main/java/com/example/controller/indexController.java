package com.example.controller;
import com.alibaba.fastjson.JSONObject;
import com.example.domain.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;

@RestController
public class indexController {
    public static final String PROVIDER_PREFIX="http://192.168.1.6:8001";
    @Resource
    RestTemplate restTemplate;
    @GetMapping("/users")
    String getUsers()
    {
        String map = restTemplate.getForObject(PROVIDER_PREFIX + "/users", String.class);
        return "消费者使用生产者的接口:"+map;
    }
    @GetMapping("/user/{id}")
    String getUserById(@PathVariable("id") Integer id)
    {
        String map = restTemplate.getForObject(PROVIDER_PREFIX + "/user/"+id, String.class);
        return "消费者使用生产者的接口:"+map;
    }
    @PostMapping("/user")
    String addUser(@RequestBody String userJson)
    {
        User user = JSONObject.parseObject(userJson,User.class);
        Integer map = restTemplate.postForObject(PROVIDER_PREFIX + "/user",user, Integer.class);
        return "消费者使用生产者的接口:"+map;
    }
}
