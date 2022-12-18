package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName TemplateConfig
 * @Description:
 * @Author 刘苏义
 * @Date 2022/12/18 17:11
 * @Version 1.0
 */
@Configuration
public class TemplateConfig {
    @Bean
    public RestTemplate restTemplate()
    {
        return new RestTemplate();
    }
}
