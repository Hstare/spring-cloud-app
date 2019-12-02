package com.hew.springcloudserver.DO;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author HeXiaoWei
 * @date 2019/11/25 21:17
 */
@Data
@Accessors(chain = true)
public abstract class BaseDO implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}
