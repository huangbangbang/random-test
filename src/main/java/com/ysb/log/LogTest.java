package com.ysb.log;

import lombok.extern.log4j.Log4j;
import org.apache.log4j.Logger;

@Log4j
public class LogTest {
    private static Logger logger = Logger.getLogger(LogTest.class);
    public static void main(String[] args) {

        String s = "jack";
        logger.info("hello {}",new UnknownError());


    }
}
