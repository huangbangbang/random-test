package com.ysb.test;

public class Test03 {
    public static void main(String[] args) {
        System.out.println(Constant.NUM);
        System.out.println(Season.SPRING.getStatus());
        Season.AUTUMN.setDes("hhhhhhh");
        System.out.println(Season.AUTUMN);
    }
}
