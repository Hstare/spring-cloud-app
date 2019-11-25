package com.hew.springcloudserver.customException;

/**
 * @author HeXiaoWei
 * @date 2019/11/23 14:13
 */
public class DaoException extends RuntimeException {

    public DaoException(String message, Throwable cause){
        super(message, cause);
    }
}
