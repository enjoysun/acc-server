package com.yunjia.lark.config;

import com.google.gson.Gson;
import com.yunjia.lark.model.system.ResponseCode;
import com.yunjia.lark.model.system.ResponseMessage;
import com.yunjia.lark.model.system.RestResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import springfox.documentation.swagger.web.ApiResourceController;
import springfox.documentation.swagger2.web.Swagger2Controller;

import javax.servlet.http.HttpServletRequest;

/**
 * @DESCRIPTION: 返回 Rest 风格的数据
 * @AUTHOR: gyli
 * @DATE: 2020/4/19 12:46 下午
 */
@RestControllerAdvice
public class ResponseHandler implements ResponseBodyAdvice {

    private static final Logger logger = LoggerFactory.getLogger(ResponseHandler.class);

    private static final String RESPONSE_DATA_REWRITE = "RESPONSE_DATA_REWRITE";

    /**
     * 可指定针对某些返回值得类型才进行 Rest 风格的封装
     * @param methodParameter
     * @param aClass
     * @return
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {

        //过滤掉 swagger2
        if(methodParameter.getDeclaringClass().equals(ApiResourceController.class)
                || methodParameter.getDeclaringClass().equals(Swagger2Controller.class)) {
            return false;
        }

        //异常信息已经做过了rest封装，此处跳过rest处理，否则返回数据会出现嵌套问题
        String name = methodParameter.getMethod().getName();
        if ("businessExceptionHandler".equals(name)) {
            return false;
        }

        //对加有 @DefaultResponse 注解的方法返回false不进行数据封装，未添加注解返回true 做数据封装
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        return request.getAttribute(RESPONSE_DATA_REWRITE) == null ? true : false;
    }

    /**
     * 返回数据封装
     * @param body
     * @param methodParameter
     * @param mediaType
     * @param aClass
     * @param serverHttpRequest
     * @param serverHttpResponse
     * @return
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

        //如果没有返回数据则返回为空
        if (body == null) {
            logger.info("leave method " + methodParameter.getMethod().getName() + " ， result  is  " + "null");
            return new RestResult(ResponseCode.SUCESS, "", ResponseMessage.SUCCESS);
        }

        //如果content-type 是 image/jpeg 则不需要做rest封装
        if (MediaType.IMAGE_JPEG.getType().equalsIgnoreCase(mediaType.getType())) {
            logger.info("leave method " + methodParameter.getMethod().getName() + " ， result  is  " + body);
            return body;
        }

        //处理返回值是String的情况,此处String 类型的返回结果，如果不做处理，则会出现 ClassCastException
        if (body instanceof String) {
            Gson gson = new Gson();
            logger.info("leave method " + methodParameter.getMethod().getName() + " ， result  is  " + gson.toJson(new RestResult(ResponseCode.SUCESS, body, "sucess")));
            return gson.toJson(new RestResult(ResponseCode.SUCESS, body, ResponseMessage.SUCCESS));
        }

        if (body instanceof RestResult) {
            logger.info("leave method " + methodParameter.getMethod().getName() + " ， result  is  " + body);
            return body;
        }

//        logger.info("leave method " + methodParameter.getMethod().getName() + " ， result  is  " + new RestResult(ResponseCode.SUCESS, body, ResponseMessage.SUCCESS));

        return new RestResult(ResponseCode.SUCESS, body, ResponseMessage.SUCCESS);
    }
}
