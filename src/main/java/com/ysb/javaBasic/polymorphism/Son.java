package com.ysb.javaBasic.polymorphism;

public class Son extends Father implements MyInterface{
    public static int id = 100;
    public static void method(){
        System.out.println("subClass");
    }
    public static void main(String[] args) {
        System.out.println(Son.id);
        Son.method();
        System.out.println(Son.i);
        Son son = new Son();
        int add = son.add(1, 2);
        System.out.println(add);
    }

}
