package com.ysb.designPattern.abstractFactoryPattern;

import java.util.concurrent.TimeUnit;

/**
 * @author Huang Bangbang
 * @date 2022/5/6 - 17:35
 */
public class RedisClusterAdapter implements CacheAdapter{
    private Redis redis = new Redis();
    @Override
    public String get(String key) {
        return redis.get(key);
    }

    @Override
    public void set(String key, String value) {
        redis.set(key,value);
    }

    @Override
    public void set(String key, String value, Long timeout, TimeUnit timeUnit) {
        redis.set(key, value, timeout, timeUnit);
    }

    @Override
    public void delete(String key) {

    }
}
