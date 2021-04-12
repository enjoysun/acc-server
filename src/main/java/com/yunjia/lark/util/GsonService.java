package com.yunjia.lark.util;

import com.google.gson.Gson;

/**
 * @Author myou
 * @Date 2021/4/12  9:59 上午
 */

/*gson实例唯一构造器*/
public class GsonService {

    private final static Gson gson;

    static {
        gson = SingleService.init();
    }

    private static class SingleService {
        public static Gson init() {
            return new Gson();
        }
    }

    public static Gson getInstance() {
        return GsonService.gson;
    }

}
