package com.telecom.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Date：2020-12-08 14:41
 * Description：
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() {
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {
       log.info(Thread.currentThread().getName()+"\t"+" ---testB");
        return "------testB";
    }

    @GetMapping("/testD")
    public String testD()
    {
        log.info("testD 测试RT");
        int age = 10/0;
        return "------testD";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    public String testHotkey(@RequestParam(value = "p1",required = false) String p1,@RequestParam(value = "p2",required = false
    ) String p2){
        return "****testHotKey*****";
    }

    public String deal_testHotKey(String p1, String p2, BlockException exception){
        return "流量访问高，请稍后访问";
    }




}
