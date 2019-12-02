package com.hew.springcloudcommon.exception;

/**
 * @author HeXiaoWei
 * @date 2019/12/2 23:20
 */
public class AuthorizationException extends RuntimeException{
    public AuthorizationException(){};
    public AuthorizationException(String message){super(message);};
    public AuthorizationException(String message, Throwable cause){super(message,cause);};
}
