package com.telecom.springcloud.controller;

import com.telecom.springcloud.domain.CommonResult;
import com.telecom.springcloud.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Date：2020-12-11 10:24
 * Description：
 */
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;


    /**
     * 扣减账户余额
     */
    @RequestMapping("/account/decrease")
    public CommonResult decrease( Long userId,Integer money){
        accountService.decrease(userId,money);
        return new CommonResult(200,"扣减账户余额成功！");
    }
}
