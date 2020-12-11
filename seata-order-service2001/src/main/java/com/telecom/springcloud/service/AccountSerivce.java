package com.telecom.springcloud.service;

import com.telecom.springcloud.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Date：2020-12-10 18:48
 * Description：
 */
@Service
@FeignClient(value = "seata-account-service")
public interface AccountSerivce {

    @PostMapping(value = "/account/decrease")
     CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") Integer money);
}
