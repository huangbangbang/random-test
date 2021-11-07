package com.ysb;

import java.util.Collection;
import java.util.stream.Stream;

public class LambdaTest {
    public static void main(String[] args) {
        //匿名内部类可以用lambda表达式来表示
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World!");
            }
        });

        //简化为如下lambda表达式形式
        new Thread(() -> System.out.println("Hello World!"));



    }
}
