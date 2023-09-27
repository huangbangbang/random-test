package com.ysb.newThread;

import java.util.concurrent.Callable;

public class MyThread implements Callable {
    @Override
    public Object call() throws Exception {
        return 5;
    }
}
