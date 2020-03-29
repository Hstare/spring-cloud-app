package com.hew.springclouddubboapi.service;

import com.hew.springclouddubboapi.Query.UserQuery;
import com.hew.springclouddubboapi.pagination.Page;

/**
 * @author HeXiaoWei
 * @date 2019/12/9 22:13
 */
public interface IUserService {
    String getUser(UserQuery userQuery);
    String getUser(String userName);
    String pageUser(UserQuery userQuery);
    String roles();
    Byte getUserState(Long id);
}
