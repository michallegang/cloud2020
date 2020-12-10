package com.telecom.springcloud.service;

import com.telecom.springcloud.entities.CommonResult;
import com.telecom.springcloud.entities.Payment;
import com.telecom.springcloud.service.impl.PaymentFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Date：2020-12-10 11:26
 * Description：
 */
@FeignClient(value = "nacos-order-consumer",fallback = PaymentFallbackService.class)
public interface PaymentService {

    @GetMapping(value = "/payment/{id}")
    public CommonResult<Payment> payment(@PathVariable("id") Long id);
}
