package com.yunjia.lark.config;

import com.google.gson.Gson;
import com.yunjia.lark.model.system.BusinessException;
import com.yunjia.lark.model.system.ResponseCode;
import com.yunjia.lark.model.system.ResponseMessage;
import com.yunjia.lark.model.system.RestResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * @DESCRIPTION: 统一异常处理
 * @AUTHOR: gyli
 * @DATE: 2020/4/19 9:57 下午
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Object businessExceptionHandler(HttpServletRequest request, Exception e, HttpServletResponse response) throws IOException {
        //默认给定系统异常，错误码固定为-1，提示语为：系统繁忙，请稍后再试
        RestResult restResult = new RestResult(ResponseCode.SYSTEM_EXCEPTION, "", ResponseMessage.SYSTEM_EXCEPTION);

        //如果是业务逻辑异常，返回固定错误码 500 和 对应的提示信息
        if (e instanceof BusinessException) {
            BusinessException businessException = (BusinessException) e;
            //业务逻辑异常，统一返回500错误码
            restResult.setCode(ResponseCode.BUSINESS_EXCEPTION);
            restResult.setMessage(businessException.getPromptMessage());
            //businessException.getMessage()+"："
            restResult.setData("");
            String errorMsg = "异常类型：" + businessException.getLocalizedMessage()
                    + ",异常所在类：" + businessException.getStackTrace()[0].getClassName()
                    + ",异常所在行数：" + businessException.getStackTrace()[0].getLineNumber();
            logger.info(errorMsg);
        } else if (e instanceof BindException) {
            //如果是参数校验异常 在model中做参数校验异常，则返回相应的提示信息
            BindException bindException = (BindException) e;
            //参数校验异常，统一返回501错误码
            restResult.setCode(ResponseCode.PARAMETER_EXCEPTION);
            //读取未通过校验的参数信息
            List<FieldError> allErrors = bindException.getFieldErrors();
            //便利追加未通过校验的参数信息，返回给前端
            StringBuilder stringBuilder = new StringBuilder();
            for (FieldError fieldError : allErrors) {
                stringBuilder.append(fieldError.getField()).append(":").append(fieldError.getDefaultMessage()).append(",");
            }
            restResult.setMessage(stringBuilder.toString());
            restResult.setData("");
            logger.info(bindException.toString());
        } else if (e instanceof ConstraintViolationException) {
            // @Validated参数验证失败触发ConstraintViolationException异常类型
            //如果是参数校验异常 在方法中做参数校验异常，则返回相应的提示信息
            ConstraintViolationException constraintViolationException = (ConstraintViolationException) e;
            //参数校验异常，统一返回501错误码
            restResult.setCode(ResponseCode.PARAMETER_EXCEPTION);
            //读取未通过校验的参数信息
            Set<ConstraintViolation<?>> set = constraintViolationException.getConstraintViolations();
            //便利追加未通过校验的参数信息，返回给前端
            StringBuilder stringBuilder = new StringBuilder();
            for (ConstraintViolation<?> constraintViolation : set) {
                stringBuilder.append(constraintViolation.getPropertyPath().toString()).append(":").append(constraintViolation.getMessageTemplate());
            }
            restResult.setMessage(constraintViolationException.getLocalizedMessage());
            restResult.setData("");
            logger.info(constraintViolationException.toString());
        } else if (e instanceof MethodArgumentNotValidException) {
            // @valid参数验证失败触发MethodArgumentNotValidException异常类型
            //如果是参数校验异常 在方法中做参数校验异常，则返回相应的提示信息
            MethodArgumentNotValidException methodArgumentNotValidException = (MethodArgumentNotValidException) e;
            //参数校验异常，统一返回501错误码
            restResult.setCode(ResponseCode.PARAMETER_EXCEPTION);

            //读取未通过校验的参数信息
            MethodParameter methodParameter = methodArgumentNotValidException.getParameter();

            //便利追加未通过校验的参数信息，返回给前端
            List<FieldError> fieldErrors = methodArgumentNotValidException.getBindingResult().getFieldErrors();
            StringBuilder stringBuilder = new StringBuilder();
            for (FieldError constraintViolation : fieldErrors) {
                stringBuilder.append(String.format("%s:%s;", constraintViolation.getField(), constraintViolation.getDefaultMessage()));
            }
            restResult.setMessage(stringBuilder);
            restResult.setData("");
            logger.info(methodArgumentNotValidException.toString());
        } else {
            //对系统级异常进行日志记录
            logger.error("系统异常", e);
        }
        return restResult;
    }

}
