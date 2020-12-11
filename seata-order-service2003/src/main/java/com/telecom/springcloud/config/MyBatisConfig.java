package com.telecom.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Date：2020-12-10 18:54
 * Description：
 */
@Configuration
@MapperScan(value = {"com.telecom.springcloud.dao"})
public class MyBatisConfig {
}
