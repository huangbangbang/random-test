package com.ysb.test;

public class LamdaTest {
    public static void main(String[] args) {
        LamdaTest test = new LamdaTest();
        MathOperation mathOperation = (a,b)->a+b;
        System.out.println(mathOperation.operation(1,2));
        System.out.println("====================================");
        int i = test.operation(1, 2, mathOperation);
        System.out.println(i);
    }
    private int operation(int a,int b,MathOperation mathOperation){
        return mathOperation.operation(a,b);
    }
}

interface MathOperation{
    int operation(int a,int b);
}
