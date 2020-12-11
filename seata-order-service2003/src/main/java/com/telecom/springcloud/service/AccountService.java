package com.telecom.springcloud.service;

import org.springframework.web.bind.annotation.RequestParam;

/**
 * Date：2020-12-11 10:17
 * Description：
 */
public interface AccountService {

    /**
     * 扣减账户余额
     */
    void decrease(@RequestParam("userId") Long userId, @RequestParam("money") Integer money);

}
