package com.telecom.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Date：2020-11-05 10:07
 * Description：
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerZkOrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerZkOrderMain80.class,args);
    }
}
