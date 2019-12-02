package com.hew.springcloudserver.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author HeXiaoWei
 * @date 2019/11/25 22:16
 */
@Getter
@AllArgsConstructor
public enum PermissionTypeEnum implements IEnum<Byte> {
    /**
     * 权限类型
     */
    VISITOR((byte)0,"可访问"),
    AUTHORIZED((byte)1,"可授权");
    private byte value;
    private String desc;

    @Override
    public Byte getValue() {
        return this.value;
    }
}
