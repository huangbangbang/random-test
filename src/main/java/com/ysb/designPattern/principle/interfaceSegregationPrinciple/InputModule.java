package com.ysb.designPattern.principle.interfaceSegregationPrinciple;

/**
 * @author Huang Bangbang
 * @date 2022/4/26 - 18:33
 */
public interface InputModule {
    /**
     * 插入数据
     */
    void insert();
    /**
     * 删除数据
     */
    void delete();
    /**
     * 修改数据
     */
    void modify();
}
