package com.yunjia.lark.util;

import com.google.gson.Gson;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author myou
 * @Date 2021/3/17  7:05 下午
 */
public class ResponseRender {

    public static void render(HttpServletResponse httpServletResponse, Object print) throws IOException {
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        // 允许自定义请求头token(允许head跨域)
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "token, Accept, Origin, X-Requested-With, Content-Type, Last-Modified");
        httpServletResponse.setHeader("Content-type", "application/json;charset=UTF-8");
        httpServletResponse.getWriter().print(GsonService.getInstance().toJson(print));
    }
}
