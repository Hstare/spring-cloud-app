package com.hew.springcloudserver.service;

import com.hew.springcloudserver.DO.UserDO;
import com.hew.springcloudserver.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author HeXiaoWei
 * @date 2019/11/21 22:33
 */
public interface UserService {
    UserDO getUserById(UserDO userDO);
}
