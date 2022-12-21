package com.ruluConfig;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MyRuleConfig
 * @Description:
 * @Author 刘苏义
 * @Date 2022/12/21 8:40
 * @Version 1.0
 */
@Configuration
public class MyRuleConfig {
    @Bean
    @LoadBalanced
    public IRule myRule(){
        return new RandomRule();
    }
}
