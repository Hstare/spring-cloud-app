package com.hew.springcloudserver.DO;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hew.springcloudserver.enums.SexEnum;
import com.hew.springcloudserver.enums.UserStateEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author HeXiaoWei
 * @date 2019/11/21 22:16
 */
@Data
@Accessors(chain = true)
@TableName("user")
@EqualsAndHashCode(callSuper = false)
public class UserDO extends BaseDO{
    @NotNull(message = "姓名不能为空")
    private String name;
    private String idCard;
    private String userName;
    private String password;
    @Min(value = 0)
    private Integer age;
    private String avatar;
    private SexEnum sex;
    private String phone;
    @Email(message = "邮箱格式不正确")
    private String email;
    private UserStateEnum state;
}
