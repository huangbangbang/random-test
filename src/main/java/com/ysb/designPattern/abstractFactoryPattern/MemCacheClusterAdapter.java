package com.ysb.designPattern.abstractFactoryPattern;

import java.util.concurrent.TimeUnit;

/**
 * @author Huang Bangbang
 * @date 2022/5/6 - 17:44
 */
public class MemCacheClusterAdapter implements CacheAdapter{
    private MemCache memCache = new MemCache();
    @Override
    public String get(String key) {
        return memCache.get(key);
    }

    @Override
    public void set(String key, String value) {
        memCache.set(key, value);
    }

    @Override
    public void set(String key, String value, Long timeout, TimeUnit timeUnit) {
        memCache.set(key, value, timeout, timeUnit);
    }

    @Override
    public void delete(String key) {
        memCache.delete(key);
    }
}
