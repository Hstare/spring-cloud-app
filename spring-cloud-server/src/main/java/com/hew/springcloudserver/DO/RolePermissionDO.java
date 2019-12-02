package com.hew.springcloudserver.DO;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hew.springcloudserver.enums.PermissionTypeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author HeXiaoWei
 * @date 2019/11/25 22:04
 */
@Data
@Accessors( chain = true )
@TableName("role_permission")
@EqualsAndHashCode(callSuper = false)
public class RolePermissionDO {
    private int role_id;
    private int permission_id;
    private PermissionTypeEnum permission_type;
}
