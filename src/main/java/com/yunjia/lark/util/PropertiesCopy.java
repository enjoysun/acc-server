package com.yunjia.lark.util;

import org.springframework.cglib.beans.BeanCopier;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author myou
 * @Date 2021/3/20  2:41 下午
 */
public class PropertiesCopy {
    public final static ConcurrentHashMap<String, BeanCopier> BEAN_COPIERS = new ConcurrentHashMap<>();

    private static String getBeanCopierKey(Class<?> src, Class<?> dest) {
        return String.format("%s:%s", src.getName(), dest.getName());
    }

    public static void copy(Object src, Object dest) {
        String key = PropertiesCopy.getBeanCopierKey(src.getClass(), dest.getClass());
        BeanCopier beanCopier;
        if (PropertiesCopy.BEAN_COPIERS.containsKey(key)) {
            beanCopier = PropertiesCopy.BEAN_COPIERS.get(key);
        } else {
            beanCopier = BeanCopier.create(src.getClass(), dest.getClass(), false);
            PropertiesCopy.BEAN_COPIERS.put(key, beanCopier);
        }
        beanCopier.copy(src, dest, null);
    }
}
