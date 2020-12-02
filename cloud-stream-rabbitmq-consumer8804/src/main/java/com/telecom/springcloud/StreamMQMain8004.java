package com.telecom.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Date：2020-12-02 8:54
 * Description：
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamMQMain8004 {

    public static void main(String[] args) {
        SpringApplication.run(StreamMQMain8004.class,args);
    }
}
