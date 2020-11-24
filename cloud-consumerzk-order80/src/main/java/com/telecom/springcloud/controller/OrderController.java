package com.telecom.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Date：2020-11-05 10:09
 * Description：
 */
@RestController
@Slf4j
public class OrderController {

    private final static String URl_PREFIX="http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public String getPaymentZk(){
        return restTemplate.getForObject(URl_PREFIX+"/payment/zk",String.class);
    }

}
