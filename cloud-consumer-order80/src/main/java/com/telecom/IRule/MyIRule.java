package com.telecom.IRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Date：2020-11-06 9:57
 * Description：
 */
@Configuration
public class MyIRule {

    @Bean
    public IRule getIRule(){
        //随机Rule
        return new RandomRule();
    }
}
