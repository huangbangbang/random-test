package com.ysb.designPattern.principle.interfaceSegregationPrinciple;

/**
 * @author Huang Bangbang
 * @date 2022/4/26 - 18:36
 */
public interface PrintModule {
    /**
     * 打印单个信息
     */
    void printOne();

    /**
     * 打印列表
     */
    void printList();
}
