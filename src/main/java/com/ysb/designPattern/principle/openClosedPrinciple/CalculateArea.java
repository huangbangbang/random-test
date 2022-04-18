package com.ysb.designPattern.principle.openClosedPrinciple;

/**
 * @author Huang Bangbang
 * @date 2022/4/13 - 09:39
 */
public interface CalculateArea {
    double PI = 3.14D;
    /**
     * 计算矩形的面积
     * @param x 长
     * @param y 宽
     * @return 矩形的面积
     */
    default double rectangle(double x, double y){
        return x * y;
    };

    /**
     * 计算三角形的面积
     * @param x 一边
     * @param y 二边
     * @param z 三边
     * @return 三角形的面积
     */

    default double triangle(double x, double y, double z){
        double p = (x + y + z )/2;
        return Math.sqrt(p * (p-x) * (p-y) * (p-z));
    };

    /**
     * 计算圆的面积
     * @param r 圆的半径
     * @return 圆的面积
     */
    default double circular(double r){
        return PI * r * r;
    };
}
