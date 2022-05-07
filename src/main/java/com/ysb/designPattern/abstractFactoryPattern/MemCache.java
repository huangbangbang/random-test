package com.ysb.designPattern.abstractFactoryPattern;

import java.util.concurrent.TimeUnit;

/**
 * @author Huang Bangbang
 * @date 2022/5/6 - 17:38
 */
public class MemCache {
    public String get(String key) {
        System.out.println("执行MemCache的get方法");
        return null;
    }

    public void set(String key, String value) {
        System.out.println("执行MemCache的set方法");
    }

    public void set(String key, String value, Long timeout, TimeUnit timeUnit) {
        System.out.println("执行MemCache的set重载方法");
    }

    public void delete(String key) {
        System.out.println("执行MemCache的delete方法");
    }
}
