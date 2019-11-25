package com.hew.springcloudserver.DO;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author HeXiaoWei
 * @date 2019/11/25 21:59
 */
@Data
@Accessors( chain = true)
@TableName("role")
public class RoleDO extends BaseDO{
    private Integer parentId;
    private String name;
    private String roleDesc;
}
