package com.ysb.designPattern.abstractFactoryPattern;

import java.util.concurrent.TimeUnit;

/**
 * @author Huang Bangbang
 * @date 2022/5/6 - 17:25
 */
public interface CacheAdapter {
    /**
     * 缓存服务器的get方法
     * @param key 根据key 取值
     * @return 返回value
     */
    String get(String key);

    /**
     * 缓存服务器的set方法
     * @param key 根据key存值
     * @param value key对应的value
     */
    void set(String key,String value);

    /**
     * 上面方法的重载方法
     * @param key
     * @param value
     * @param timeout
     * @param timeUnit
     */
    void set(String key, String value, Long timeout, TimeUnit timeUnit);

    /**
     * 缓存服务器的删除方法
     * @param key 根据key删除键值对
     */
    void delete(String key);
}
