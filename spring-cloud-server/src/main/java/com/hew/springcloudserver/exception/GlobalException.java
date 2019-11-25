package com.hew.springcloudserver.exception;

import com.alibaba.fastjson.JSON;
import com.hew.springcloudserver.VO.ResultVO;
import com.hew.springcloudserver.enums.CodeMessage;
import org.apache.ibatis.exceptions.PersistenceException;
import org.mybatis.spring.MyBatisSystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.sql.SQLSyntaxErrorException;

/**
 * @author HeXiaoWei
 * @date 2019/11/23 11:16
 */
@RestControllerAdvice
public class GlobalException {
    Logger logger = LoggerFactory.getLogger(getClass());
    private ResultVO<String> resultVO = new ResultVO<>();

    @ExceptionHandler
    public String exceptionHandler(Exception e) {
        logger.info("全局异常exceptionHandler");
        logger.warn(e.getMessage());
        if (e instanceof NoHandlerFoundException) {
            resultVO.setCode(CodeMessage.NOT_FOUND.getCode())
                    .setMsg(CodeMessage.NOT_FOUND.getMessage());
        } else if (e instanceof IllegalStateException) {
            resultVO.setCode(CodeMessage.ERROR.getCode())
                    .setMsg("非法状态异常");
        } else if (e instanceof BindException) {
            resultVO.setCode(CodeMessage.ERROR.getCode())
                    .setMsg("请求参数类型与实体参数类型不匹配");
        } else if (e instanceof PersistenceException){
            resultVO.setCode(CodeMessage.ERROR.getCode())
                    .setMsg("MyBatis持久化异常");
        } else if (e instanceof SQLSyntaxErrorException){
            resultVO.setCode(CodeMessage.ERROR.getCode())
                    .setMsg("MyBatis SQL语法错误异常");
        } else if (e instanceof MyBatisSystemException){
            resultVO.setCode(CodeMessage.ERROR.getCode())
                    .setMsg("MyBatis系统异常");
        } else {
            resultVO.setCode(CodeMessage.ERROR.getCode())
                    .setMsg("服务器发生错误，请检查服务器");
        }
        e.printStackTrace();
        return JSON.toJSONString(resultVO);
    }
}
