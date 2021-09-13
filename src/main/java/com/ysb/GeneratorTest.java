package com.ysb;

import java.util.ArrayList;

public class GeneratorTest {
    public static void main(String[] args) {
        Generator generator = Generator.create(ArrayList.class);
        ArrayList next =(ArrayList) generator.next();
        ArrayList next1 =(ArrayList) generator.next();
        ArrayList next2 =(ArrayList) generator.next();
        next.add(1);
        next1.add(2);
        System.out.println(next.hashCode());
        System.out.println(next1.hashCode());
        System.out.println(next2.hashCode());
    }
}
class Generator<T>{
    private Class<T> aClass;

    public Generator(Class<T> aClass) {
        this.aClass = aClass;
    }

    public T next(){
        try {
            return aClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static <T> Generator<T> create(Class<T> aClass){
        return new Generator<T>(aClass);
    }
}