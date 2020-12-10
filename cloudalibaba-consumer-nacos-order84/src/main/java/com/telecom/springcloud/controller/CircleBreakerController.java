package com.telecom.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.telecom.springcloud.entities.CommonResult;
import com.telecom.springcloud.entities.Payment;
import com.telecom.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Date：2020-12-10 10:33
 * Description：
 */
@RestController
@Slf4j
public class CircleBreakerController {

    @Value("${service-url.nacos-user-service}")
    private String serviceUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private PaymentService paymentService;

    //什么都不配置
   /* @RequestMapping("/consumer/fallback/{id}")
    public CommonResult<Payment> fallback(@PathVariable Long id){

        CommonResult commonResult = restTemplate.getForObject(serviceUrl + "/payment/" + id, CommonResult.class, id);

        if(id == 4){
            throw new IllegalArgumentException("数据格式不正确，参数类型异常");
        }else if(commonResult.getData() == null){
            throw new NullPointerException("未查到数据 空指针异常");
        }
        return commonResult;
    }
*/

    /**
     * 只配置@SentinelResource 默认报错提示
     * @param id
     * @return
     */
  /*  @RequestMapping("/consumer/fallback/{id}")
    @SentinelResource(value = "fallback")
    public CommonResult<Payment> fallback(@PathVariable Long id){

        CommonResult commonResult = restTemplate.getForObject(serviceUrl + "/payment/" + id, CommonResult.class, id);

        if(id == 4){
            throw new IllegalArgumentException("数据格式不正确，参数类型异常");
        }else if(commonResult.getData() == null){
            throw new NullPointerException("未查到数据 空指针异常");
        }
        return commonResult;
    }*/


    /**
     * 只负责处理业务异常
     * @param id
     * @return
     */
  /*  @RequestMapping("/consumer/fallback/{id}")
    @SentinelResource(value = "fallback",fallback = "handlerFallback")
    public CommonResult<Payment> fallback(@PathVariable Long id){

        CommonResult commonResult = restTemplate.getForObject(serviceUrl + "/payment/" + id, CommonResult.class, id);

        if(id == 4){
            throw new IllegalArgumentException("数据格式不正确，参数类型异常");
        }else if(commonResult.getData() == null){
            throw new NullPointerException("未查到数据 空指针异常");
        }
        return commonResult;
    }*/

    /**
     * 同时处理业务异常和熔断降级
     * @param id
     * @return
     */
    @RequestMapping("/consumer/fallback/{id}")
    @SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler = "blockHandler")
    public CommonResult<Payment> fallback(@PathVariable Long id){

        CommonResult commonResult = restTemplate.getForObject(serviceUrl + "/payment/" + id, CommonResult.class, id);

        if(id == 4){
            throw new IllegalArgumentException("数据格式不正确，参数类型异常");
        }else if(commonResult.getData() == null){
            throw new NullPointerException("未查到数据 空指针异常");
        }
        return commonResult;
    }



    public CommonResult handlerFallback(@PathVariable  Long id,Throwable e) {
        Payment payment = new Payment(id,"null");
        return new CommonResult<>(444,"兜底异常handlerFallback,exception内容  "+e.getMessage(),payment);
    }

    public CommonResult blockHandler(@PathVariable  Long id,BlockException blockException) {
        Payment payment = new Payment(id,"null");
        return new CommonResult<>(445,"blockHandler-sentinel限流,无此流水: blockException  "+blockException.getMessage(),payment);
    }

    @GetMapping(value = "/consumer/openfeign/{id}")
    public CommonResult<Payment> payment(@PathVariable("id") Long id) {
        return paymentService.payment(id);
    }



}
