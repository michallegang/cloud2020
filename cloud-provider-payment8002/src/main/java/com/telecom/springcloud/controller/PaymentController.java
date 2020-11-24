package com.telecom.springcloud.controller;

import com.telecom.springcloud.entities.CommonResult;
import com.telecom.springcloud.entities.Payment;
import com.telecom.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * Date：2020-10-29 19:42
 * Description：
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("插入结果 {}",result);
        if(result >0){
            return new CommonResult(200,"添加成功,端口:"+serverPort,result);
        }else{
            return new CommonResult(404,"添加失败,端口:"+serverPort,null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);

        if(payment != null){
            return new CommonResult(200,"查询成功,端口:"+serverPort,payment);
        }else {
            return new CommonResult(444,"未查询到对应记录,查询ID:"+id+",端口:"+serverPort,null);
        }

    }

    @GetMapping("/payment/lb")
    public String getLb(){
        return serverPort;
    }

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout(){

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;

    }



}
