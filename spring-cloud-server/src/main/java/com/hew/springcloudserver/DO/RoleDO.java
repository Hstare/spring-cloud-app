package com.hew.springcloudserver.DO;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author HeXiaoWei
 * @date 2019/11/25 21:59
 */
@Data
@Accessors( chain = true)
@EqualsAndHashCode(callSuper = false)
public class RoleDO extends BaseDO{
    private Integer parentId;
    private String name;
    private String roleDesc;
}
