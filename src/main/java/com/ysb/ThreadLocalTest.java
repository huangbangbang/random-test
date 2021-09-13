package com.ysb;

public class ThreadLocalTest {
    public static java.lang.ThreadLocal threadLocal = new java.lang.ThreadLocal();
    public static java.lang.ThreadLocal threadLocal1 = new java.lang.ThreadLocal();
    public static void print(String s){
        System.out.println(s+" "+threadLocal.get());
    }
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("threadLocalValue1");
                threadLocal1.set("threadLocalValue3");
                print("thread1");
                System.out.println(threadLocal.get());
                System.out.println(threadLocal1.get());
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("threadLocalValue2");
                print("thread1");
                System.out.println(threadLocal.get());
            }
        });

        thread1.start();
        thread2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(threadLocal.get());
    }
}
