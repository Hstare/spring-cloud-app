package com.hew.springcloudcommon.exception;

import com.alibaba.fastjson.JSON;
import com.hew.springcloudcommon.VO.ResultVO;
import com.hew.springcloudcommon.enums.CodeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ValidationException;

/**
 * @author HeXiaoWei
 * @date 2019/11/23 11:16
 */
@RestControllerAdvice
public class GlobalException {
    Logger logger = LoggerFactory.getLogger(getClass());
    private ResultVO<String> resultVO = new ResultVO<>();
    @ExceptionHandler
    public String exceptionHandler(HttpServletRequest request,Exception e) {
        logger.error("全局异常exceptionHandler");
        logger.error(e.getMessage());
        logger.error("Addr: {}, ERROR: {}",request.getRemoteAddr(),e.getLocalizedMessage());
        if (e instanceof NoHandlerFoundException) {
            this.resultVO.setCode(CodeMessage.NOT_FOUND.getCode())
                    .setMsg(CodeMessage.NOT_FOUND.getMessage());
        } else if (e instanceof AuthorizationException) {
            this.resultVO.setCode(CodeMessage.UNAUTHORIZED.getCode())
                    .setMsg(CodeMessage.UNAUTHORIZED.getMessage());
        } else if (e instanceof HttpRequestMethodNotSupportedException || e instanceof TypeMismatchException
                    || e instanceof MissingServletRequestParameterException){
            this.resultVO.setCode(CodeMessage.INVALID_PARAM.getCode())
                    .setMsg(CodeMessage.INVALID_PARAM.getMessage());
        } else if (e instanceof ValidationException || e instanceof MethodArgumentNotValidException){
            this.resultVO.setCode(CodeMessage.INVALID_PARAM.getCode())
                    .setMsg(CodeMessage.INVALID_PARAM.getMessage());
        } else {
            this.resultVO.setCode(CodeMessage.ERROR.getCode())
                    .setMsg("服务器发生错误，请检查服务器");
        }
        e.printStackTrace();
        return JSON.toJSONString(this.resultVO);
    }
}
