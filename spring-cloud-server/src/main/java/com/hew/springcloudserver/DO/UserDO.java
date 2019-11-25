package com.hew.springcloudserver.DO;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.github.dozermapper.core.Mapping;
import com.hew.springcloudserver.enums.SexEnum;
import com.hew.springcloudserver.enums.UserStateEnum;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author HeXiaoWei
 * @date 2019/11/21 22:16
 */
@Data
@Accessors(chain = true)
@TableName("user")
public class UserDO extends BaseDO{
    private String name;
    private String idCard;
    private String userName;
    private String password;
    private Integer age;
    private String avatar;
    private SexEnum sex;
    private String phone;
    private String email;
    private UserStateEnum state;
}
