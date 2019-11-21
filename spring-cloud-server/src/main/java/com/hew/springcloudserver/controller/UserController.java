package com.hew.springcloudserver.controller;

import com.alibaba.fastjson.JSON;
import com.hew.springcloudserver.DO.UserDO;
import com.hew.springcloudserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HeXiaoWei
 * @date 2019/11/21 22:16
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("getUser")
    public String getUser(UserDO userDO){
        UserDO userById = userService.getUserById(userDO);
        return JSON.toJSONString(userById);
    }
}
