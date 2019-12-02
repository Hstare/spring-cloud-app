package com.hew.springcloudserver.DO;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author HeXiaoWei
 * @date 2019/11/25 22:02
 */
@Data
@Accessors( chain = true)
@TableName("permission")
@EqualsAndHashCode(callSuper = false)
public class PermissionDO extends BaseDO {
    private Integer parentId;
    private String name;
    private String permissionDesc;
}
