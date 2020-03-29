package com.hew.springcloudapi.controller;

import com.hew.springclouddubboapi.Query.UserQuery;
import com.hew.springclouddubboapi.pagination.Page;
import com.hew.springclouddubboapi.service.IUserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HeXiaoWei
 * @date 2019/12/8 17:20
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Reference
    IUserService userService;

    @GetMapping("getUser")
    public String getUser(UserQuery userQuery) {
        return userService.getUser(userQuery);
    }

    @GetMapping("pageUser")
    public String pageUser(UserQuery userQuery) {
        return userService.pageUser(userQuery);
    }
    @GetMapping("roles")
    public String roles(){
        return userService.roles();
    }
}
