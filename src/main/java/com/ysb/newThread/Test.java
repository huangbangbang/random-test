package com.ysb.newThread;

import java.time.Duration;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        FutureTask<Integer> future = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 6;
            }
        });

        new Thread(future).start();
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
//                try {
//                    Thread.sleep(3000);
//                    System.out.println("========inner==========");
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                int a = 10/0;
//                System.out.println("========inner==========");

//                while (true){
//
//                }
            }
        }).start();
        System.out.println("===================");
        Thread.sleep(1000);
        System.out.println("===================");
        Runnable task = ()->{
            System.out.println("hello");
        };
        new Thread(task).start();
    }
}
