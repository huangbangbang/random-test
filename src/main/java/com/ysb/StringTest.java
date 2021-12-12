package com.ysb;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class StringTest {
    public static void main(String[] args) {
        /*String s = "123456";
        String s1 = s.substring(0,4);
        System.out.println(s1);
        */
//        LocalDateTime time = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
//        if (time.isBefore(LocalDateTime.now())){
//            System.out.println("可以比较");
//        }
//        System.out.println(time);

        String s = String.valueOf(100);
        Integer integer = Integer.valueOf("100");
        System.out.println(s);
        System.out.println(integer);

    }
}
