package com.telecom.springcloud.service.impl;

import com.telecom.springcloud.dao.PaymentDao;
import com.telecom.springcloud.entities.Payment;
import com.telecom.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Date：2020-10-29 19:40
 * Description：
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
