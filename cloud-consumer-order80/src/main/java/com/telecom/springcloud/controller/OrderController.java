package com.telecom.springcloud.controller;

import com.telecom.springcloud.entities.CommonResult;
import com.telecom.springcloud.entities.Payment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Date：2020-10-30 16:31
 * Description：
 */
@RestController
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    public static final String PAYMENTURL_PREFIX="http://CLOUD-PAYMENT-SERVICE";

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENTURL_PREFIX+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/get/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){

        return restTemplate.getForObject(PAYMENTURL_PREFIX+"/payment/get/"+id,CommonResult.class);

    }

}
