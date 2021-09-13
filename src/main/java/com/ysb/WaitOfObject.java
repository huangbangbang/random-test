package com.ysb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WaitOfObject {

    public static void main(String[] args){
        /*URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL u:urLs
             ) {
            System.out.println(u);
        }*/
        final ObjectTest objectTest = new ObjectTest();

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                try {
                    String string = objectTest.remove();
                    System.out.println(string);
                } catch (InterruptedException e) {
                    System.out.println("interrupt is executed");
                }catch (Exception e) {
                    System.out.println("Exception is thrown");
                }
            }
        };
        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                objectTest.add("china");
            }
        };


        try {
            Thread thread1 = new Thread(runnable1, "thread1");
            thread1.start();
            Thread.sleep(500);
            Thread thread2 = new Thread(runnable1, "thread2");
            thread2.start();
            Thread.sleep(500);
            Thread thread3 = new Thread(runnable2, "thread3");
            thread3.start();
            Thread.sleep(1000);
            thread1.interrupt();
            thread2.interrupt();
        } catch (InterruptedException e) {
        }

    }
}

class ObjectTest{
    private List synList;

    public ObjectTest() {
        synList = Collections.synchronizedList(new ArrayList<>());
    }
    public String remove() throws InterruptedException {
        synchronized (synList){
            while (synList.isEmpty()){
                System.out.println("synList is empty");
                synList.wait();
                System.out.println("synList is waiting");
            }
            String remove =(String) synList.remove(0);
            return remove;
        }
    }
    public void add(String element){
        System.out.println("start adding new element");
        synchronized (synList){
           synList.add(element);
            System.out.println("new element "+element+" was added");
            synList.notifyAll();
            System.out.println("all threads were notified");
        }
        System.out.println("end adding new element");
    }
}