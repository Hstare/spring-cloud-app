package com.hew.springcloudserver.DTO;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

/**
 * @author HeXiaoWei
 * @date 2019/11/23 22:34
 */
@Data
public class UserDTO {
    private Long id;
    private String name;
    private String idCard;
    private String userName;
    private Integer age;
    private String avatar;
    private Byte sex;
    private String phone;
    private String email;
    private Byte state;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}
