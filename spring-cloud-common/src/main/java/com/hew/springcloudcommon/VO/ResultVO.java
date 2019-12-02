package com.hew.springcloudcommon.VO;

import com.hew.springcloudcommon.enums.CodeMessage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author HeXiaoWei
 * @date 2019/11/30 14:54
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
public class ResultVO<T> {
    private static final long serialVersionUID = 42L;
    private Integer code;
    private String msg;
    private T data;
    public ResultVO(){
        this(CodeMessage.SUCCESS.getCode(),CodeMessage.SUCCESS.getMessage(),null);
    }
    public ResultVO(T data){
        this(CodeMessage.SUCCESS.getCode(),CodeMessage.SUCCESS.getMessage(),data);
    }
}
