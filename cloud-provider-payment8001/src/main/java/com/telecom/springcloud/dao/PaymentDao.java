package com.telecom.springcloud.dao;

import com.telecom.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Date：2020-10-29 19:16
 * Description：
 */
@Mapper
public interface PaymentDao {

     int create(Payment payment);

     Payment getPaymentById(@Param("id") Long id);

}
