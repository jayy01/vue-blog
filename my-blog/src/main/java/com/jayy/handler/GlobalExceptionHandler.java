package com.jayy.handler;

import com.jayy.utils.Response;
import com.jayy.utils.ResponseResult;
import com.jayy.utils.ResultCode;
import org.apache.shiro.ShiroException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.SocketTimeoutException;

/**
 * @Author jayy
 * @Description 全局异常处理
 * @Date 2020/6/23 16:09
 * @Version 1.0
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    // 运行时异常
    @ResponseStatus(HttpStatus.BAD_REQUEST) //赋值http的请求状态
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseResult handler(RuntimeException e){
        System.out.println(e.getMessage());
        return Response.makeErrRsp(e.getMessage());
    }
    // 捕捉shiro的异常
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(ShiroException.class)
    public ResponseResult handle401(ShiroException e) {
        return Response.makeRsp(ResultCode.UNAUTHORIZED,e.getMessage());
    }
    //处理Assert的异常
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseResult handler(IllegalArgumentException e) throws IOException {
        return Response.makeErrRsp(e.getMessage());
    }
    // @Validated 校验错误异常处理
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseResult handler(MethodArgumentNotValidException e) throws IOException {
        BindingResult bindingResult = e.getBindingResult();
        ObjectError objectError = bindingResult.getAllErrors().stream().findFirst().get();
        return Response.makeErrRsp(e.getMessage());
    }
    /*// 所有异常
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) //赋值http的请求状态
    @ExceptionHandler(value = SocketTimeoutException.class)
    public ResponseResult handler(SocketTimeoutException e){
        return Response.makeRsp(ResultCode.INTERNAL_SERVER_ERROR,e.getMessage(),null);
    }*/
}
