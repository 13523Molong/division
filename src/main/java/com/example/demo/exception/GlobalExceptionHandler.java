package com.example.demo.exception;

import com.example.demo.pojo.response;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    //处理全局的错误，返回response对象
    @ExceptionHandler(Exception.class)
    public response handleException(Exception e){
        e.printStackTrace();
        return response.error(StringUtils.hasLength(e.getMessage())?e.getMessage():"操作失败");
    }
}
