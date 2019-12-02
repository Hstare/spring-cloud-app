package com.hew.springcloudserver.DTO;

import com.hew.springcloudserver.DO.RoleDO;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author HeXiaoWei
 * @date 2019/11/30 11:42
 */
@Data
@Accessors( chain = true )
public class RoleDTO{
    private RoleDO roleDO;
    private List<RoleDO> roles;

}
