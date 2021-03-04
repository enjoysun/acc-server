package com.yunjia.lark.model.system;

/**
 * @DESCRIPTION: 业务逻辑异常类
 * @AUTHOR: gyli
 * @DATE: 2020/4/19 9:52 下午
 */
public class BusinessException extends RuntimeException {

    //返回给前端页面的提示信息
    private String promptMessage;

    //异常信息
    private String errorMsg;

    public BusinessException(String promptMessage, String errorMsg) {
        super(errorMsg);
        this.promptMessage = promptMessage;
        this.errorMsg = errorMsg;
    }

    /**
     * 抛出逻辑异常
     * @param errorMsg
     * @return
     */
    public static BusinessException le(String promptMessage, String errorMsg){
        return new BusinessException(promptMessage, errorMsg);
    }

    public String getPromptMessage() {
        return promptMessage;
    }

    public void setPromptMessage(String promptMessage) {
        this.promptMessage = promptMessage;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
