package com.hew.springcloudserver;

import com.github.dozermapper.core.Mapper;
import com.hew.springclouddubboapi.Query.UserQuery;
import com.hew.springcloudserver.BO.UserRoleBO;
import com.hew.springcloudserver.DTO.RoleDTO;
import com.hew.springcloudserver.mapper.UserMapper;
import com.hew.springcloudserver.service.UserService;
//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
class SpringCloudServerApplicationTests {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    UserMapper userMapper;

    @Autowired
    UserService userService;

    @Autowired
    Mapper mapper;

    @Test
    void contextLoads() {
        List<UserRoleBO> userRoleBOS = userMapper.userRoles();
        System.out.println(userRoleBOS);
    }

    @Test
    void testAddUser(){
        UserQuery userQuery = new UserQuery();
        userQuery.setAge(15).setCreateTime(new Date()).setName("王麻子2").setSex((byte)1);
        Integer integer = userService.addUser(userQuery);
        logger.info("----"+integer);
    }
    @Test
    public void test11(){
        List<RoleDTO> roleDOS = userMapper.allRoles();
        ArrayList<RoleDTO> objects = new ArrayList<>();
        for(RoleDTO role: roleDOS){
            RoleDTO map = mapper.map(role, RoleDTO.class);
            objects.add(map);
        }
        logger.info(String.valueOf(objects.toString()));
    }
    @Test
    public void test12() {
        List<RoleDTO> roleDTOS = userService.allRoles();
        logger.info(roleDTOS.toString());
    }
    @Test
    public void test13() {
        List<RoleDTO> roleDOS = userMapper.allRoles();
        logger.info(roleDOS.toString());
    }
}
