package com.hew.springcloudserver.dubbo;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.dozermapper.core.Mapper;
import com.hew.springcloudcommon.VO.ResultVO;
import com.hew.springclouddubboapi.Query.UserQuery;
import com.hew.springclouddubboapi.service.IUserService;
import com.hew.springcloudserver.DTO.RoleDTO;
import com.hew.springcloudserver.DTO.UserDTO;
import com.hew.springcloudserver.service.UserService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author HeXiaoWei
 * @date 2019/12/8 21:17
 */
@Service
public class IUserServiceImpl implements IUserService {
    @Autowired
    UserService userService;

    @Autowired
    Mapper mapper;
    @Override
    public String getUser(UserQuery userQuery) {
        UserDTO userById = userService.getUserById(userQuery);
        return JSON.toJSONString(new ResultVO<>(userById));
    }

    @Override
    public String getUser(String userName) {
        UserDTO userDTO = userService.getUserByUserName(userName);
        return userDTO.toString();
    }

    @Override
    public String pageUser(UserQuery userQuery) {
        Page<UserQuery> page = new Page<>();
        page.setCurrent(userQuery.getCurrent());
        page.setSize(userQuery.getSize());
        IPage<UserDTO> userDTOIPage = userService.listUser(page, userQuery);
        return JSON.toJSONString(new ResultVO<>(userDTOIPage));
    }

    @Override
    public String roles() {
        List<RoleDTO> roleDTOS = userService.allRoles();
        return JSON.toJSONString(new ResultVO<>(roleDTOS));
    }

    @Override
    public Byte getUserState(Long id) {
        return userService.getUserState(id);
    }
}
