package com.ysb.designPattern.principle.openClosedPrinciple;

/**
 * @author Huang Bangbang
 * @date 2022/4/13 - 09:51
 *
 *   对开闭原则（open closed principle）的一个理解
 *   1. 用到了Java 8 的新特性 :接口的默认方法
 *   2. 用到了面向抽象编程 Java中的抽象即是接口或者抽象类 接口是行为的抽象 抽象类是数据的抽象（子类的模版实现）
 *   3. 用到了匿名内部类
 *   对拓展开放 对修改关闭
 *   extension open ：拓展开放可以通过实现类实现 既可以拓展接口的已有方法的定制实现 也可以拓展接口没有的方法 毕竟接口是所有子类的共有行为的抽象 某些子类会有自己的独特行为（行为即方法）
 *   modification closed：修改关闭指的是接口里的行为抽象一经确定就不要改动
 */
public class CalculateAreaTest {
    public static final Double NEWPI = 3.1415926;
    public static void main(String[] args) {
        System.out.println("匿名实现类实现矩形面积的计算");
        System.out.println(new CalculateArea() {
        }.rectangle(4,6));
        System.out.println("匿名实现类实现三角形面积的计算");
        System.out.println(new CalculateArea() {
        }.triangle(6,6,6));
        System.out.println("匿名实现类实现圆形面积的计算,对精度不满意可以重写方法");
        System.out.println(new CalculateArea() {
            @Override
            public double circular(double r){
                return NEWPI * r * r;
            }
        }.circular(1));
        System.out.println("匿名实现类可以拓展接口没有的方法");
        System.out.println(new CalculateArea() {
            public double trapezoid(double upper,double lower,double height){
                return (upper + lower) * height /2;
            }
        }.trapezoid(2,4,2));
    }
}
