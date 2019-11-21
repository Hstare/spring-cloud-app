package com.hew.springcloudserver.DO;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author HeXiaoWei
 * @date 2019/11/21 22:16
 */
@Data
@Accessors(chain = true)
@TableName("user")
public class UserDO {
    private Long id;
    private String name;
    @TableField(value = "id_card")
    private String idCard;
    @TableField(value = "user_name")
    private String userName;
    private String password;
    private Integer age;
    private String avatar;
    private Integer sex;
    private String phone;
    private String email;
    private Integer state;
    @TableField(value = "create_time")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @TableField(value = "update_time")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}
