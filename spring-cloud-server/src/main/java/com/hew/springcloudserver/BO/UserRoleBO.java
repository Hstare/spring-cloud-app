package com.hew.springcloudserver.BO;

import com.hew.springcloudserver.DO.RoleDO;
import com.hew.springcloudserver.DTO.UserDTO;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author HeXiaoWei
 * @date 2019/11/26 20:21
 */
@Data
@Accessors( chain = true )
public class UserRoleBO {
    private UserDTO userDTO;
    private List<RoleDO> roles;
}
