package com.ysb.javaBasic.polymorphism;

public interface MyInterface {
    static final int i =100;
    default  int add(int a,int b){
        return a+b;
    }
}
