package com.ysb.test.randomtest;

import sun.misc.Service;
import java.util.Iterator;
import java.util.ServiceLoader;


public class Test02 {
    public static void main(String[] args) {
        Iterator<SPI> providers = Service.providers(SPI.class);
        ServiceLoader<SPI> load = ServiceLoader.load(SPI.class);
        while (providers.hasNext()){
            SPI next = providers.next();
            System.out.println(next);
            next.execute();
        }
        System.out.println("=====================");
        Iterator<SPI> iterator = load.iterator();
        while (iterator.hasNext()){
            SPI next = iterator.next();
            System.out.println(next);
            next.execute();
        }
    }
}
