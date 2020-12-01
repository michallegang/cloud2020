package com.telecom.springcloud.controller;

import com.telecom.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Date：2020-12-01 16:12
 * Description：
 */
@RestController
@Slf4j
public class SendMessageController {
    @Resource
    private IMessageProvider messageProvider;

    @RequestMapping("/send")
    public String sendMessage(){
        String result = messageProvider.send();
        log.info("发送的消息内容:"+result);
        return result;
    }


}
