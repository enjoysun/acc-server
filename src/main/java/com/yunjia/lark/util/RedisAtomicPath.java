package com.yunjia.lark.util;

/**
 * @Author myou
 * @Date 2021/3/25  10:18 上午
 */
public class RedisAtomicPath {
    /*原子(自增和过期)*/
    public final static String INCR_EXPIRE = "script/lua/incr-expire.lua";
}
