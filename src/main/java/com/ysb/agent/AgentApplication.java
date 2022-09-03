package com.ysb.agent;

import java.lang.instrument.Instrumentation;

/**
 * @author Huang Bangbang
 * @date 2022/5/9 - 16:31
 */
public class AgentApplication {
    public static void premain(String arg, Instrumentation instrumentation) {
        System.err.println("agent startup , args is " + arg);
    }
}
