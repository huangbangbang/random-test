package com.ysb.designPattern.principle.interfaceSegregationPrinciple;

/**
 * @author Huang Bangbang
 * @date 2022/4/26 - 18:42
 */
public class StudentScoreImpl implements PrintModule,StatisticModule,InputModule{

    public static InputModule getInputModule(){
        return (InputModule) new StudentScoreImpl();
    }

    public static PrintModule getPrintModule(){
        return (PrintModule) new StudentScoreImpl();
    }

    public static StatisticModule getStatisticModule(){
        return (StatisticModule) new StudentScoreImpl();
    }
    @Override
    public void printOne() {
        System.out.println("打印单个信息");
    }

    @Override
    public void printList() {
        System.out.println("打印列表信息");
    }

    @Override
    public void getTotal() {
        System.out.println("统计总数");
    }

    @Override
    public void getAverage() {
        System.out.println("计算平均数");
    }

    @Override
    public void insert() {
        System.out.println("插入单条数据");
    }

    @Override
    public void delete() {
        System.out.println("删除单条数据");
    }

    @Override
    public void modify() {
        System.out.println("修改单条数据");
    }
}
