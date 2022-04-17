package com.ysb.threadLocal;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Huang Bangbang
 * @date 2022/4/17 - 12:58
 */
public class ThreadLocalTest {
    public static void main(String[] args) {
        ThreadLocal<Map> threadLocal = new ThreadLocal<>();
        HashMap<String, String> map = new HashMap<>(1);
        map.put("id","1001");
        map.put("name","jack");
        map.put("age","12");
        threadLocal.set(map);
        HashMap<String, String> anotherMap = new HashMap<>(10);
        threadLocal.set(anotherMap);
        System.out.println(threadLocal.get().get("id"));
        System.out.println(threadLocal.get().get("name"));
        new Thread(() -> {
            threadLocal.set(map);
            System.out.println(threadLocal.get().get("name"));
            System.out.println(threadLocal.get().get("age"));
        }).start();
    }
}
