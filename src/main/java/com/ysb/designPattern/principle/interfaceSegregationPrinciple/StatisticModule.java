package com.ysb.designPattern.principle.interfaceSegregationPrinciple;

/**
 * @author Huang Bangbang
 * @date 2022/4/26 - 18:39
 */
public interface StatisticModule {
    /**
     * 统计总数
     */
    void getTotal();
    /**
     * 计算平均数
     */
    void getAverage();
}
