package com.hew.springcloudserver.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hew.springcloudcommon.VO.ResultVO;
import com.hew.springcloudserver.DTO.RoleDTO;
import com.hew.springcloudserver.DTO.UserDTO;
import com.hew.springcloudserver.Query.UserQuery;
import com.hew.springcloudserver.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author HeXiaoWei
 * @date 2019/11/21 22:16
 */
@RestController
@RequestMapping("user")
public class UserController {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private UserService userService;

    @GetMapping("getUser")
    public String getUser(UserQuery userQuery)  {
        UserDTO userById = userService.getUserById(userQuery);
        return JSON.toJSONString(new ResultVO<>(userById));
    }

    @GetMapping("pageUser")
    public String pageUser(Page<UserQuery> page,UserQuery userQuery){
        IPage<UserDTO> userDOIPage =  userService.listUser(page, userQuery);
        return JSON.toJSONString(new ResultVO<>(userDOIPage));
    }

    @GetMapping("roles")
    public String roles(){
        List<RoleDTO> roleDTOS = userService.allRoles();
        return JSON.toJSONString(new ResultVO<>(roleDTOS));
    }
}
