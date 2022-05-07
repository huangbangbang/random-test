package com.ysb.designPattern.abstractFactoryPattern;

/**
 * @author Huang Bangbang
 * @date 2022/5/6 - 17:24
 *    抽象工厂模式的进一步学习.
 *
 *    一两年前学习过一遍设计模式,那时还没有参加工作,没有一个实际的企业开发经验,编程能力也严重不足.
 *    现在虽然在企业做业务开发,但还是个初级程序员,接触的东西很少,既接触不到顶层设计,也不会有底层架构的机会.
 *    但还是觉得要逐渐培养自己的编程思想,提高自己的编程能力和对业务的一个理解.
 *
 *    回过头来审视自己:
 *     1. 对Proxy,InvocationHandler等具有代表性的反射代理知识相关的类(接口)缺乏了解,看到别人使用的时候都不知道这个类(接口)是用来干什么的.
 *     2. 缺乏一种设计和系统架构的思想,因为业务开发经验不足,技术学习不够,只会在Java程序上去做一些深究,抑或是在业务上去做一些简单的CRUD.跳不出具体的业务去面向设计编程.
 *
 */
public class Test {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        RedisClusterAdapter redisClusterAdapter = JDKProxyFactory.getProxy(CacheAdapter.class, RedisClusterAdapter.class);
        redisClusterAdapter.set("name","jack");
        String name = redisClusterAdapter.get("name");
        System.out.println(name);
        MemCacheClusterAdapter memCacheClusterAdapter = JDKProxyFactory.getProxy(CacheAdapter.class, MemCacheClusterAdapter.class);
        memCacheClusterAdapter.set("name","tom");
        String s = memCacheClusterAdapter.get("name");
        System.out.println(s);
    }
}
