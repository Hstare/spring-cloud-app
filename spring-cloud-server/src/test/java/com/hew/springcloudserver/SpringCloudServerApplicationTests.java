package com.hew.springcloudserver;

import com.hew.springcloudserver.DO.UserDO;
import com.hew.springcloudserver.Query.UserQuery;
import com.hew.springcloudserver.mapper.UserMapper;
import com.hew.springcloudserver.service.UserService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class SpringCloudServerApplicationTests {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    UserMapper userMapper;

    @Autowired
    UserService userService;

    @Test
    void contextLoads() {
        UserDO userDO = userMapper.selectById(1);
        System.out.println(userDO.toString());
    }

    @Test
    void testAddUser(){
        UserQuery userQuery = new UserQuery();
        userQuery.setAge(15).setCreateTime(new Date()).setName("王麻子2").setSex((byte)1);
        Integer integer = userService.addUser(userQuery);
        logger.info("----"+integer);
    }
}
