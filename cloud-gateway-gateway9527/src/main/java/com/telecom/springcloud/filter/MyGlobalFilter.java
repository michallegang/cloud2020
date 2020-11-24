package com.telecom.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * Date：2020-11-23 9:29
 * Description：
 */
@Component
@Slf4j
public class MyGlobalFilter implements GlobalFilter,Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("全局过滤器启动");
        return chain.filter(exchange).then(Mono.fromRunnable(()->{
            log.info("返回前过滤");
        }));
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
