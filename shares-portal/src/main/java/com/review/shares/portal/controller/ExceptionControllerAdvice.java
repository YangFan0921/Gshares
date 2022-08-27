package com.review.shares.portal.controller;

import com.review.shares.portal.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//对控制器增加额外功能
@RestControllerAdvice
@Slf4j
public class ExceptionControllerAdvice {

    //异常处理
    @ExceptionHandler
    //参数决定此方法处理什么样的异常
    public String handleServiceException(ServiceException e){
        log.error("业务发生异常",e);
        return e.getMessage();
    }

    @ExceptionHandler
    public String handleException(Exception e){
        log.error("其他异常",e);
        return e.getMessage();
    }


}
