package com.telecom.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Date：2020-11-06 17:10
 * Description：
 */
@Configuration
public class FeignLogConfig {

    @Bean
    Logger.Level feignLogger(){
        return Logger.Level.FULL;
    }
}
