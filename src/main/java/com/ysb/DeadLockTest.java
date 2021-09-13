package com.ysb;

public class DeadLockTest {
    public static void main(String[] args) {
        Integer integer1 = new Integer(1);
        Integer integer2 = new Integer(2);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (integer1) {
                    System.out.println("=======");
                    synchronized (integer2) {
                        System.out.println("=======");
                    }
                }


            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (integer2) {
                    System.out.println("=======");
                    synchronized (integer1) {
                        System.out.println("=======");
                    }
                }


            }

        });
        thread1.start();
        thread2.start();
    }
}

