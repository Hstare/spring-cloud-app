package com.hew.springcloudserver.VO;

import com.hew.springcloudserver.enums.CodeMessage;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author HeXiaoWei
 * @date 2019/11/23 11:48
 */
@Data
@Accessors(chain = true)
public class ResultVO<T> implements Serializable {
    private static final long serialVersionUID = 42L;
    private Integer code = CodeMessage.SECCUSS.getCode();
    private String msg = CodeMessage.SECCUSS.getMessage();
    private T data;
    public ResultVO(){}
    public ResultVO(T data){
        super();
        this.data = data;
    }
}
