package com.telecom.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Date：2020-11-05 17:08
 * Description：
 */
@RestController
@Slf4j
public class OrderController {

    private static final String URL_PREFIX = "http://consul-provider-payment";


    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public String getConsulPayment(){
        return restTemplate.getForObject(URL_PREFIX+"/payment/consul",String.class);

    }



}
