package com.hew.springcloudserver.Query;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author HeXiaoWei
 * @date 2019/11/23 14:42
 */
@Data
@Accessors(chain = true)
public class UserQuery {
    private Long id;
    private String name;
    private String idCard;
    private String userName;
    private String password;
    private Integer age;
    private String avatar;
    private Byte sex;
    private String phone;
    private String email;
    private Byte state;
    private Date createTime;
    private Date updateTime;
}
