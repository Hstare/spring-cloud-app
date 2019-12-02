package com.hew.springcloudserver.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author HeXiaoWei
 * @date 2019/11/23 21:01
 */
@Getter
@AllArgsConstructor
public enum UserStateEnum implements IEnum<Byte> {
    /**
     * 用户状态
     */
    NORMAL((byte) 0,"正常状态"), LOCKED((byte) 1,"被锁定"),OBSOLETE((byte) 2,"已废弃");

    private Byte value;
    private String desc;

    @Override
    public Byte getValue() {
        return this.value;
    }
}
