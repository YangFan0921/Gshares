package com.review.shares.portal.controller;

import com.review.shares.portal.exception.ServiceException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
//对控制器增加额外功能
@RestControllerAdvice
public class ExceptionControllerAdvice {
    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ExceptionControllerAdvice.class);
    //</editor-fold>

    //异常处理
    //参数决定此方法处理什么样的异常
    @ExceptionHandler
    public String handleServiceException(ServiceException e) {
        log.error("业务发生异常", e);
        return e.getMessage();
    }

    @ExceptionHandler
    public String handleException(Exception e) {
        log.error("其他异常", e);
        return e.getMessage();
    }
}
