package com.yunjia.lark.model.system;

/**
 * @DESCRIPTION: new class
 * @AUTHOR: gyli
 * @DATE: 2020/4/19 8:51 下午
 */
public final class ResponseCode {
    //成功
    public static final String SUCESS = "200";

    //服务端程序异常失败
    public static final String BUSINESS_EXCEPTION = "500";

    //参数校验异常
    public static final String PARAMETER_EXCEPTION = "501";

    //认证失败
    public static final String AUTHORIZATION_FAILURE = "401";

    //系统异常
    public static final String SYSTEM_EXCEPTION = "-1";
}
