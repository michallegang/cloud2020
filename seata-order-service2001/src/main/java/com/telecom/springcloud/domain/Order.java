package com.telecom.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Date：2020-12-10 18:23
 * Description：
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order
{
    private Long id;

    private Long userId;

    private Long productId;

    private Integer count;

    private Integer money;

    private Integer status; //订单状态：0：创建中；1：已完结
}
