package com.example.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient("spring-cloud-provider-8001")
@Service
public interface IndexService {
    @GetMapping("/provider/user/{id}")
    String getId(@PathVariable("id") Long id);
}
