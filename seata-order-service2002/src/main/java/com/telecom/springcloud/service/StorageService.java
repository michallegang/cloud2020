package com.telecom.springcloud.service;

/**
 * Date：2020-12-11 9:41
 * Description：
 */
public interface StorageService {
    void decrease(Long productId, Integer count);
}
