package com.hew.springcloudserver.enums;

import com.alibaba.fastjson.annotation.JSONType;
import com.baomidou.mybatisplus.core.enums.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author HeXiaoWei
 * @date 2019/11/23 20:50
 */
@Getter
@AllArgsConstructor
public enum  SexEnum implements IEnum<Byte> {
    /**
     * 性别
     */
    MALE((byte)0,"男"), FEMALE((byte)1,"女");

    private byte value;
    private String desc;

    @Override
    public Byte getValue() {
        return this.value;
    }
}
