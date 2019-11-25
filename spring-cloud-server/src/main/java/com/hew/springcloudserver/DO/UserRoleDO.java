package com.hew.springcloudserver.DO;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author HeXiaoWei
 * @date 2019/11/25 22:03
 */
@Data
@Accessors( chain = true )
@TableName("user_role")
public class UserRoleDO extends BaseDO {
    private Long userId;
    private Integer roleId;
}
