package com.ysb.enumeration;

import com.ysb.Constant;

import java.util.Arrays;

public class EnumTest {
    public static void main(String[] args) {
        System.out.println(Constant.NUM);
        System.out.println(Season.SPRING.getStatus());
        Season.AUTUMN.setDes("hhhhhhh");
        System.out.println(Season.AUTUMN);
        Season[] values = Season.values();
        System.out.println(Arrays.toString(values));
        System.out.println(Season.SPRING.name());
        System.out.println(Season.SPRING.ordinal());

        FatherEnum.BUY.process();
        FatherEnum.SELL.process();
    }
}
