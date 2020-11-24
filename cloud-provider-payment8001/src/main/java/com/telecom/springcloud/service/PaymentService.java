package com.telecom.springcloud.service;

import com.telecom.springcloud.entities.Payment;

/**
 * Date：2020-10-29 19:39
 * Description：
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(Long id);
}
