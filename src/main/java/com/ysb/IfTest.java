package com.ysb;

import java.util.Arrays;

public class IfTest {
    public static void main(String[] args) {
        int a =4;
        if (a>5){
            System.out.println("i enter if");
        }else{
            System.out.println("i enter else if");
        }

        String str = "--";
        String[] split = str.split("-", -1);
        System.out.println(Arrays.toString(split));
        System.out.println(split.length);
        for (int i = 0; i < split.length; i++) {
            if ("".equals(split[i])){
                System.out.println("array "+ i +"is blank");
            }
            System.out.println(split[i]);

        }
    }
}
