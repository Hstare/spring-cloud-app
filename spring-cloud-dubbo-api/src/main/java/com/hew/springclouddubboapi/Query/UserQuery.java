package com.hew.springclouddubboapi.Query;

import com.hew.springclouddubboapi.pagination.Page;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author HeXiaoWei
 * @date 2019/11/23 14:42
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class UserQuery extends Page<UserQuery>{
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
