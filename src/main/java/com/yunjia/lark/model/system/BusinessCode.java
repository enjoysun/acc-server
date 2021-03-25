package com.yunjia.lark.model.system;

import org.apache.http.HttpStatus;

public interface BusinessCode extends HttpStatus {

    /** 系统异常 **/
    int SYSTEM_EXCEPTION = 1000;

    /** 参数校验异常 **/
    int PARAMETER_EXCEPTION = 1001;

}
