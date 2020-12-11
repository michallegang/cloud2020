package com.telecom.springcloud.controller;

import com.telecom.springcloud.domain.CommonResult;
import com.telecom.springcloud.domain.Order;
import com.telecom.springcloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Date：2020-12-11 8:48
 * Description：
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order){
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }

}
