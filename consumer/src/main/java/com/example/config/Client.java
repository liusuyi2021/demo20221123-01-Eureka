package com.example.config;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @ClassName Client
 * @Description:
 * @Author 刘苏义
 * @Date 2022/12/20 12:47
 * @Version 1.0
 */

@FeignClient("sp")
public interface Client {
    @GetMapping("/users")
    String getUsers();
    @GetMapping("/user/{id}")
    String getUserById(@PathVariable("id") Integer id);
    @PostMapping("/user")
    Integer addUser(@RequestBody String userJson);

}

