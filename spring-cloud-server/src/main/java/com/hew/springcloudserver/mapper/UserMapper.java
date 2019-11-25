package com.hew.springcloudserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hew.springcloudserver.DO.UserDO;
import com.hew.springcloudserver.DTO.UserDTO;
import com.hew.springcloudserver.Query.UserQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author HeXiaoWei
 * @date 2019/11/21 22:16
 */
@Mapper
public interface UserMapper extends BaseMapper<UserDO>{
    IPage<UserDTO> listUser(Page page, @Param("userQuery") UserQuery userQuery);
}
