package com.telecom.springcloud.service.impl;

import com.telecom.springcloud.entities.CommonResult;
import com.telecom.springcloud.entities.Payment;
import com.telecom.springcloud.service.PaymentService;
import org.springframework.stereotype.Component;

/**
 * Date：2020-12-10 11:29
 * Description：
 */
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> payment(Long id) {
        return new CommonResult<>(44444,"服务降级返回,---PaymentFallbackService",new Payment(id,"errorSerial"));
    }
}
