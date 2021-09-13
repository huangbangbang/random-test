package com.ysb.test;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallbackTest {
    public static void main(String[] args) {
        Store store = new Store("苹果官方旗舰店");
        SyncBuyer buyer = new SyncBuyer(store, "黄帮帮", "macBook");
        String s = buyer.orderGood();
        System.out.println(s);
    }
}

interface OrderResult {
    String getOrderResult(String state);
}

@Data
class SyncBuyer implements OrderResult, Callable {

    private Store store;
    private String buyerName;
    private String goodName;

    public SyncBuyer(Store store, String buyerName, String goodName) {
        this.store = store;
        this.buyerName = buyerName;
        this.goodName = goodName;
    }


    public String orderGood() {
        FutureTask futureTask = new FutureTask<>(new SyncBuyer(this.store, this.buyerName, this.goodName));
        Thread thread = new Thread(futureTask);
        //Thread thread = new Thread(new SyncBuyer(this.store, this.buyerName, this.goodName));
        thread.start();
        System.out.println(Thread.currentThread().getName() + "调用");
        try {
            String goodsInfo = (String) futureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        String goodsInfo = store.returnOrderGoodsInfo(this);
        myFeeling();
        return goodsInfo;
    }

    private void myFeeling() {
        String[] feeling = {"激动", "平静", "沮丧", "开心"};
        int i = new Random().nextInt(4);
        String s = feeling[i];
        System.out.println("我是" + this.buyerName + "，我现在感觉" + s);
    }

    @Override
    public String getOrderResult(String state) {
        return "在" + this.getStore().getName() + "购买的" + this.goodName + state;
    }


    @Override
    public Object call() throws Exception {
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + "异步调用");
        return store.returnOrderGoodsInfo(this);
    }

   /* @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"异步调用");
        store.returnOrderGoodsInfo(this);
    }*/
}

@Data
class Store {
    private String name;

    public Store(String name) {
        this.name = name;
    }

    public String returnOrderGoodsInfo(OrderResult orderResult) {
        String[] states = {"已付款", "待发货", "已发货", "已收货"};
        Random random = new Random();
        int i = random.nextInt(4);
        String state = states[i];

        return orderResult.getOrderResult(state);
    }
}