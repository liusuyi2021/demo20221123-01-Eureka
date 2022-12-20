package com.example.service;


import com.example.domain.User;

import java.util.List;

/**
 * @ClassName UserService
 * @Description:
 * @Author 刘苏义
 * @Date 2022/12/18 16:14
 * @Version 1.0
 */
public interface UserService {
    public User getUserBy(Integer id);

    public List<User> getUserList();

    public Integer addUser(User user);
}
