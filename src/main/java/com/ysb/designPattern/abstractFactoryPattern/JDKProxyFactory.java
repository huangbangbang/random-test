package com.ysb.designPattern.abstractFactoryPattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author Huang Bangbang
 * @date 2022/5/6 - 17:46
 */
public class JDKProxyFactory {
    public static <T> T getProxy(Class cacheClazz,Class<? extends CacheAdapter> cacheAdapter) throws InstantiationException, IllegalAccessException {
        InvocationHandler handler = new JDKInvocationHandler(cacheAdapter.newInstance());
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        return (T) Proxy.newProxyInstance(classLoader,new Class[]{cacheClazz},handler);
    }
}
