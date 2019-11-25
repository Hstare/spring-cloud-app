package com.hew.springcloudserver.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hew.springcloudserver.DO.UserDO;
import com.hew.springcloudserver.DTO.UserDTO;
import com.hew.springcloudserver.Query.UserQuery;

import java.lang.reflect.InvocationTargetException;

/**
 * @author HeXiaoWei
 * @date 2019/11/21 22:33
 */
public interface UserService {
    UserDTO getUserById(UserQuery userQuery);
    IPage<UserDTO> listUser(Page<UserQuery> page, UserQuery userQuery);
    Integer addUser(UserQuery userQuery);
}
