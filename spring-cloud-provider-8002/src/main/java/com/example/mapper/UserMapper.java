package com.example.mapper;

import com.example.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ClassName UserMapper
 * @Description:
 * @Author εθδΉ
 * @Date 2022/12/18 16:06
 * @Version 1.0
 */
@Mapper
public interface UserMapper {
    public User getUserBy(Integer id);

    public List<User> getUserList();

    public Integer addUser(User user);
}
