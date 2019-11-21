package com.hew.springcloudserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hew.springcloudserver.DO.UserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author HeXiaoWei
 * @date 2019/11/21 22:16
 */
@Mapper
public interface UserMapper extends BaseMapper<UserDO> {
}
