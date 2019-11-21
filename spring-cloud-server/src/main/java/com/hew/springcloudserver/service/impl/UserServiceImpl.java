package com.hew.springcloudserver.service.impl;

import com.hew.springcloudserver.DO.UserDO;
import com.hew.springcloudserver.mapper.UserMapper;
import com.hew.springcloudserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PrivateKey;

/**
 * @author HeXiaoWei
 * @date 2019/11/21 22:43
 */
@Service
public class UserServiceImpl implements UserService {
    @SuppressWarnings("all")
    @Autowired
    private UserMapper userMapper;
    @Override
    public UserDO getUserById(UserDO userDO) {
        return userMapper.selectById(userDO.getId());
    }
}
