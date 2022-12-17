package com.example.controller;
import com.example.service.IndexService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
public class indexController {
    @Resource
    IndexService index;
    @GetMapping("/user/{id}")
    String getId(@PathVariable("id") Long id)
    {
        String ID = index.getId(id);
        return "消费者使用生产者的接口:"+ID;
    }
}
