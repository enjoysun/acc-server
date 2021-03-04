package com.yunjia.lark.model.system;

import java.io.Serializable;

/**
 * @DESCRIPTION: 统一返回 Rest 风格的数据结构
 * @AUTHOR: gyli
 * @DATE: 2020/4/19 12:37 下午
 */
public class RestResult implements Serializable {

    //成功或者失败的code错误码
    private String code;

    //成功是返回的数据，失败是返回具体的异常信息
    private Object data;

    //失败时返回的提示信息，给前段进行页面展示的信息
    private Object message;

    //服务器当前时间戳
    private long currentTime;

    public RestResult() {
    }

    public RestResult(String code, Object data, Object message) {
        this.code = code;
        this.data = data;
        this.message = message;
        this.currentTime = System.currentTimeMillis();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public long getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(long currentTime) {
        this.currentTime = currentTime;
    }

    @Override
    public String toString() {
        return "RestResult{" +
                "code='" + code + '\'' +
                ", data=" + data +
                ", message=" + message +
                ", currentTime='" + currentTime + '\'' +
                '}';
    }
}
