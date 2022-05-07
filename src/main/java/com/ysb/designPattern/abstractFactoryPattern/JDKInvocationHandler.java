package com.ysb.designPattern.abstractFactoryPattern;

import cn.hutool.core.util.ClassLoaderUtil;
import com.sun.org.apache.xml.internal.security.utils.ClassLoaderUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Huang Bangbang
 * @date 2022/5/6 - 17:50
 */
public class JDKInvocationHandler implements InvocationHandler {

    private CacheAdapter cacheAdapter;

    public JDKInvocationHandler(CacheAdapter cacheAdapter) {
        this.cacheAdapter = cacheAdapter;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return CacheAdapter.class.getMethod(method.getName()).invoke(cacheAdapter,args);
    }
}
