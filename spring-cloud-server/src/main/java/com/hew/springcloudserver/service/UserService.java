package com.hew.springcloudserver.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hew.springclouddubboapi.Query.UserQuery;
import com.hew.springcloudserver.DTO.RoleDTO;
import com.hew.springcloudserver.DTO.UserDTO;

import java.util.List;

/**
 * @author HeXiaoWei
 * @date 2019/11/21 22:33
 */
public interface UserService {
    UserDTO getUserById(UserQuery userQuery);
    UserDTO getUserByUserName(String userName);
    IPage<UserDTO> listUser(Page<UserQuery> page, UserQuery userQuery);
    Integer addUser(UserQuery userQuery);
    List<RoleDTO> allRoles();
    Byte getUserState(Long id);
}
