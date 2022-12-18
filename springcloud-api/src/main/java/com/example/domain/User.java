package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName User
 * @Description:
 * @Author 刘苏义
 * @Date 2022/12/18 16:00
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    Integer id;
    String name;
    String age;
    String phone;
    String datasource;
}
