package com.ysb;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class LogTest {
    public static void main(String[] args) {
        LogTest logTest = new LogTest();
        logTest.method();
        log.error("发生错误了");
    }

    private void method() {
        log.info("进入到method中");
    }
}
