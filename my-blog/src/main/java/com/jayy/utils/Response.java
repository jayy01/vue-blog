package com.jayy.utils;

/**
 * @Author jayy
 * @Description 将结果转换为封装后的对象
 * @Date 2020/6/22 10:02
 * @Version 1.0
 */
public class Response {
    private final static String SUCCESS = "success";

    private final static String FAIL = "fail";

    public static <T> ResponseResult<T> makeOKRsp() {
        return new ResponseResult<T>().setCode(ResultCode.SUCCESS).setMsg(SUCCESS);
    }

    public static <T> ResponseResult<T> makeOKRsp(String message) {
        return new ResponseResult<T>().setCode(ResultCode.SUCCESS).setMsg(message);
    }

    public static <T> ResponseResult<T> makeOKRsp(T data) {
        return new ResponseResult<T>().setCode(ResultCode.SUCCESS).setMsg(SUCCESS).setData(data);
    }

    public static <T> ResponseResult<T> makeErrRsp(String message) {
        return new ResponseResult<T>().setCode(ResultCode.FAIL).setMsg(message);
    }

    public static <T> ResponseResult<T> makeRsp(ResultCode code, String msg) {
        return new ResponseResult<T>().setCode(code).setMsg(msg);
    }

    public static <T> ResponseResult<T> makeRsp(ResultCode code, String msg, T data) {
        return new ResponseResult<T>().setCode(code).setMsg(msg).setData(data);
    }
}
