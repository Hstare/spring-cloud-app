package com.hew.springcloudserver.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import com.hew.springcloudserver.DO.UserDO;
import com.hew.springcloudserver.DTO.UserDTO;
import com.hew.springcloudserver.Query.UserQuery;
import com.hew.springcloudserver.mapper.UserMapper;
import com.hew.springcloudserver.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author HeXiaoWei
 * @date 2019/11/21 22:43
 */
@Service
public class UserServiceImpl implements UserService{
    Logger logger = LoggerFactory.getLogger(getClass());
//    Mapper mapper = DozerBeanMapperBuilder.buildDefault();
    @Autowired
    Mapper mapper;
    @SuppressWarnings("all")
    @Autowired
    private UserMapper userMapper;
    @Override
    public UserDTO getUserById(UserQuery userQuery) {
        UserDO userDO = userMapper.selectById(userQuery.getId());
        UserDTO userDTO = mapper.map(userDO, UserDTO.class);
        return userDTO;
    }

    @Override
    public IPage<UserDTO> listUser(Page<UserQuery> page, UserQuery userQuery) {
        return userMapper.listUser(page, userQuery);
    }

    @Override
    public Integer addUser(UserQuery userQuery) {
        UserDO userDO = mapper.map(userQuery, UserDO.class);
        logger.info(userDO.toString());
        return userMapper.insert(userDO);
    }

}
