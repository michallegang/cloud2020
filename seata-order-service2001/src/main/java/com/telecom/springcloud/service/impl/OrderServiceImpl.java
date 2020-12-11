package com.telecom.springcloud.service.impl;

import com.telecom.springcloud.dao.OrderDao;
import com.telecom.springcloud.domain.Order;
import com.telecom.springcloud.service.AccountSerivce;
import com.telecom.springcloud.service.OrderService;
import com.telecom.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Date：2020-12-10 18:34
 * Description：
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private StorageService storageService;

    @Autowired
    private AccountSerivce accountSerivce;

    @Override
    @GlobalTransactional(name = "fpx_create_order",rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("-------> 新建订单开始");
        orderDao.create(order);

        log.info("------>订单微服务调用库存微服务 开始扣减库存");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("------>订单微服务调用库存微服务 结束扣减库存");

        log.info("------>订单微服务调用账户微服务 开始扣减账户");
        accountSerivce.decrease(order.getUserId(),order.getMoney());
        log.info("------>订单微服务调用账户微服务 结束扣减账户");

        log.info("------> 修改订单状态开始");
         orderDao.update(order.getUserId(),0);
        log.info("------> 修改订单状态结束");

        log.info("------->订单结束了");



    }
}
