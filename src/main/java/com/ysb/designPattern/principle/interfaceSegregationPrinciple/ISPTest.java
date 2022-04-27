package com.ysb.designPattern.principle.interfaceSegregationPrinciple;

/**
 * @author Huang Bangbang
 * @date 2022/4/26 - 16:32
 *    对接口隔离原则的一个理解:
 *    接口隔离原则（Interface Segregation Principle,ISP）要求程序员尽量将臃肿庞大的接口拆分成更小的和更具体的接口,让接口中只包含客户感兴趣的方法.
 *    2002 年罗伯特·C.马丁给“接口隔离原则”的定义是:客户端不应该被迫依赖于它不使用的方法（Clients should not be forced to depend on methods they do not use）.
 *    该原则还有另外一个定义:一个类对另一个类的依赖应该建立在最小的接口上（The dependency of one class to another one should depend on the smallest possible interface）.
 */
public class ISPTest{
    public static void main(String[] args) {
        InputModule inputModule = StudentScoreImpl.getInputModule();
        PrintModule printModule = StudentScoreImpl.getPrintModule();
        StatisticModule statisticModule = StudentScoreImpl.getStatisticModule();

        inputModule.insert();
        inputModule.delete();
        inputModule.modify();

        printModule.printOne();
        printModule.printList();

        statisticModule.getTotal();
        statisticModule.getAverage();
    }
}
