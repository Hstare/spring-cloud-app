package com.hew.springclouddubboapi.pagination;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author HeXiaoWei
 * @date 2019/12/10 21:49
 */
@Data
@Accessors(chain = true)
@ToString
public class OrderItem {
    /**
     * 需要进行排序的字段
     */
    private String column;

    /**
     * 是否正序排列，默认 true
     */
    private boolean asc = true;
}
