package com.ysb.test.randomtest;

/**
 * @author Administrator
 */
public class Test01 {
    public static void main(String[] args) {
        new A();
    }
}
class A {
    private B b = new B();
}

class B{
    private A a = new A();
}