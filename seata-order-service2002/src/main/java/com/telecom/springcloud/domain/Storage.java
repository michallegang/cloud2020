package com.telecom.springcloud.domain;

import lombok.Data;

/**
 * Date：2020-12-11 9:38
 * Description：
 */
@Data
public class Storage {

    private Long id;

    // 产品id
    private Long productId;

    //总库存
    private Integer total;


    //已用库存
    private Integer used;


    //剩余库存
    private Integer residue;
}

