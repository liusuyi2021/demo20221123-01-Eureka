package com.example.config;
import com.example.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

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
    List<User> getUsers();
    @GetMapping("/user/{id}")
    User getUserById(@PathVariable("id") Integer id);
    @PostMapping("/user")
    Integer addUser(@RequestBody String userJson);

}

