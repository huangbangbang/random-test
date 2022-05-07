package com.ysb.designPattern.abstractFactoryPattern;

import java.util.concurrent.TimeUnit;

/**
 * @author Huang Bangbang
 * @date 2022/5/6 - 17:36
 */
public class Redis {

    public String get(String key) {
        System.out.println("执行redis的get方法");
        return null;
    }

    public void set(String key, String value) {
        System.out.println("执行redis的set方法");
    }

    public void set(String key, String value, Long timeout, TimeUnit timeUnit) {
        System.out.println("执行redis的set重载方法");
    }

    public void delete(String key) {
        System.out.println("执行redis的delete方法");
    }
}
