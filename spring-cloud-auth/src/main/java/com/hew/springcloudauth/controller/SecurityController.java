package com.hew.springcloudauth.controller;

import com.alibaba.fastjson.JSON;
import com.hew.springcloudauth.DTO.TokenDTO;
import com.hew.springcloudauth.Query.UserQuery;
import com.hew.springcloudauth.util.JWTUtils;
import com.hew.springclouddubboapi.service.IUserService;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author HeXiaoWei
 * @date 2019/12/24 23:27
 */
@RestController
@RequestMapping("auth")
public class SecurityController {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Reference
    IUserService userService;

    @GetMapping("login")
    public String login(UserQuery userQuery) {
        String token = null;
        if ("123456".equals(userQuery.getPassword()) && "张三".equals(userQuery.getName())) {
            token = JWTUtils.createToken(userQuery);
        }
        String user = userService.getUser(userQuery.getUserName());
        logger.info("用户信息："+user);
        return token;
    }

    @GetMapping("verify")
    public String verify(HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");
        logger.info("authorization --->{}", authorization);
        TokenDTO tokenDTO = JWTUtils.verifyToken(authorization);
//        if (tokenDTO != null && tokenDTO.getVerified()) {
//            return true;
//        }
        return JSON.toJSONString(tokenDTO);
    }
}
