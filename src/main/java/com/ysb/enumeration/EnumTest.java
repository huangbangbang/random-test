package com.ysb.enumeration;

import com.ysb.Constant;

public class EnumTest {
    public static void main(String[] args) {
        System.out.println(Constant.NUM);
        System.out.println(Season.SPRING.getStatus());
        Season.AUTUMN.setDes("hhhhhhh");
        System.out.println(Season.AUTUMN);
    }
}
