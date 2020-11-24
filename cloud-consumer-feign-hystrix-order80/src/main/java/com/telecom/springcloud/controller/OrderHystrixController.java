package com.telecom.springcloud.controller;

import com.telecom.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Date：2020-11-09 15:58
 * Description：
 */
@RestController
@Slf4j
//@DefaultProperties(defaultFallback = "paymentGlobalFallbackMethod")
public class OrderHystrixController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Integer id){
        String result = paymentHystrixService.paymentInfo_ok(id);
        log.info("order-hystrix-80 paymentInfo_ok result:"+result);
        return result;
    }



    // 单个方法上设置降级处理
    /**
     *
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String paymentInfo_timeout(@PathVariable("id") Integer id){
         String result = paymentHystrixService.paymentInfo_timeout(id);
        log.info("order-hystrix-80 paymentInfo_timeout  result:"+result);

        return "order-hystrix-80 paymentInfo_timeout  result:";
    }
    **/

    //通过全局设置降级处理
    /**
     *
     @GetMapping("/consumer/payment/hystrix/timeout/{id}")
     @HystrixCommand
     public String paymentInfo_timeout(@PathVariable("id") Integer id){
         String result = paymentHystrixService.paymentInfo_timeout(id);
         log.info("order-hystrix-80 paymentInfo_timeout  result:"+result);

         return "order-hystrix-80 paymentInfo_timeout  result:";
     }
     **/
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfo_timeout(@PathVariable("id") Integer id){
       String result = paymentHystrixService.paymentInfo_timeout(id);
     //   log.info("order-hystrix-80 paymentInfo_timeout  result:"+result);

        return result;
    }

    //兜底方法
    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id){
        return "我是消费者80，对付支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,(┬＿┬)";
    }

    //兜底方法
    public String paymentGlobalFallbackMethod(){
        return "全局报错异常,(┬＿┬)";
    }

}
