package com.hew.springcloudcommon.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author HeXiaoWei
 * @date 2019/11/23 12:03
 */
@Getter
@AllArgsConstructor
public enum CodeMessage {
    /**
     * 编码消息
     */
    SUCCESS(200,"请求成功"),
    UPDATE_SUCCESS(201,"修改数据成功"),
    SAVE_SUCCESS(201,"新建数据成功"),
    DELETE_SUCCESS(201,"删除数据成功"),
    ACCEPTED(202,"请求已经进入后台排队（异步任务）"),
    BAD_REQUEST(400,"请求错误，服务器没有进行新建或修改数据的操作"),
    UNAUTHORIZED(401,"未授权"),
    TOKEN_ERROR(401,"令牌错误"),
    USERNAME_NON_EXIST(401,"用户名不存在"),
    PASSWORD_ERROR(401,"密码错误"),
    FORBIDDEN(403,"用户得到授权，但是访问是被禁止的"),
    NOT_FOUND(404,"请求资源不存在"),
    NOT_ACCEPTABLE(406,"请求的格式不可得"),
    GONE(410,"请求的资源被永久删除，且不会再得到的"),
    INTERNAL_SERVER_ERROR(500,"服务器发生错误，请检查服务器"),
    BAD_GATEWAY(502,"网关错误"),
    SERVICE_UNAVAILABLE(503,"服务不可用，服务器暂时过载或维护"),
    GATEWAY_TIME_OUT(504,"网关超时"),
    NETWORK_AUTHENTICATION_REQUIRED(511,"需要网络身份验证"),
    /**
     * 自定义异常消息
     */
    INVALID_PARAM(1000,"无效参数"),
    ERROR(-1,"");

    private int code;
    private String Message;
}
