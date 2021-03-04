package com.yunjia.lark.annotation;

import java.lang.annotation.*;

/**
 * @author gyli
 *
 * 返回数据统一封装注解
 * controller 层中的方法默认会使用RestResult对象进行包装统一返回格式。
 * 如果 conttroller 中有些方法不需要进行包装返回则可以使用 @DefaultResponse 注解进行修饰后后就会默认返回
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
public @interface DefaultResponse {
}
