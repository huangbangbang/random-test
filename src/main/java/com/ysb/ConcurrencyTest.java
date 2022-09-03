package com.ysb;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

import static java.lang.Thread.sleep;

/**
 * @author Huang Bangbang
 * @date 2022/8/30 - 17:32
 */
public class ConcurrencyTest implements Runnable{
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new ConcurrencyTest());
        Thread thread2 = new Thread(new ConcurrencyTest());
        thread1.start();
        thread2.start();
        ConcurrencyTest object1 = new ConcurrencyTest();

        object1.synMethod(2);

    }

    private synchronized  void synMethod(int i) throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+"正在执行");
        sleep(8000);
        System.out.println("我出来了");
    }

    @Override
    public void run() {
        ConcurrencyTest object2 = new ConcurrencyTest();
        try {
            object2.synMethod(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
