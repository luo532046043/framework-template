package com.chen.response;


import com.chen.enums.ResponseCodeEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局返回对象
 * @author Chenwl
 * @version 1.0.0
 */
public class BaseResponse<T> {

    /**返回码*/
    private int code;
    /**返回说明*/
    private String message;
    /**返回内容*/
    private T value;

    /**无内容-成功响应*/
    public static BaseResponse SUCCESS_RESPONSE = new BaseResponse(ResponseCodeEnum.SUCCESS);
    /**无内容-异常响应*/
    public static BaseResponse ERROR_RESPONSE = new BaseResponse(ResponseCodeEnum.ERROR);
    /**无内容-错误响应*/
    public static BaseResponse FAIL_RESPONSE = new BaseResponse(ResponseCodeEnum.FAIL);

    public BaseResponse() {
        this.code = ResponseCodeEnum.SUCCESS.getCode();
        this.message = ResponseCodeEnum.SUCCESS.getValue();
    }

    public BaseResponse(T value) {
        this.code = ResponseCodeEnum.SUCCESS.getCode();
        this.message = ResponseCodeEnum.SUCCESS.getValue();
        this.value = value;
    }

    public BaseResponse(ResponseCodeEnum codeEnum) {
        this.code = codeEnum.getCode();
        this.message = codeEnum.getValue();
    }

    public BaseResponse(ResponseCodeEnum codeEnum, T value) {
        this.code = codeEnum.getCode();
        this.message = codeEnum.getValue();
        this.value = value;
    }

    public BaseResponse(int code, String message, T value) {
        this.code = code;
        this.message = message;
        this.value = value;
    }

    public BaseResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", code);
        map.put("message", message);
        map.put("value", value);
        return map;
    }

    public static BaseResponse getErrorResponse(String message) {
        return new BaseResponse(ResponseCodeEnum.ERROR.getCode(), message, null);
    }

    public static BaseResponse getFailResponse(String message) {
        return new BaseResponse(ResponseCodeEnum.FAIL.getCode(), message, null);
    }

    public static BaseResponse getSuccessResponse(String message) {
        return new BaseResponse(ResponseCodeEnum.SUCCESS.getCode(), message, null);
    }

    public static <T> BaseResponse getSuccessResponse(T value) {
        return new BaseResponse(ResponseCodeEnum.SUCCESS, value);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
