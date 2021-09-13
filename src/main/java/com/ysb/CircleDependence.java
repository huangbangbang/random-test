package com.ysb;

/**
 * @author Administrator
 */
public class CircleDependence {
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