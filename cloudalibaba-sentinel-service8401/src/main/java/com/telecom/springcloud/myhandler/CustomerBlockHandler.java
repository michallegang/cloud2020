package com.telecom.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.telecom.springcloud.entities.CommonResult;

/**
 * Date：2020-12-09 17:26
 * Description：
 */
public class CustomerBlockHandler {

    public static  CommonResult handleException(BlockException exception) {
        return new CommonResult(2020, "自定义限流处理信息....CustomerBlockHandler");

    }
    public static CommonResult handleException2(BlockException exception) {
        return new CommonResult(2020, "自定义限流处理信息....CustomerBlockHandler2");

    }
}
