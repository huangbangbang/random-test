package com.ysb.designPattern.principle.dependenceInversionPrinciple;

import com.ysb.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Huang Bangbang
 * @date 2022/4/27 - 08:53
 *   对依赖倒转原则的一个理解(Dependence Inversion Principle,DIP)的一个理解
 *   依赖倒置原则是Robert C.Martin于1996年在C++Report上发表的文章中提出的.
 *   依赖倒置原则是指在设计代码架构时,高层模块不应该依赖于底层模块,二者都应该依赖于抽象.抽象不应该依赖于细节,细节应该依赖抽象.
 *   Java中面向抽象编程指的是面向接口或抽象类编程.接口作为一种行为的抽象,抽象类作为一种数据的抽象(子类的模版实现).
 *   本次的框架架构对比Java的集合框架(Collection Framework).
 *   <img width="640" height="320" src="https://github.com/huangbangbang/random-test/blob/master/src/main/java/com/ysb/img.png" alt="">
 *   <a href="https://github.com/huangbangbang/random-test/blob/master/src/main/java/com/ysb/img.png">继承关系图</a>
 *   发现了一个问题:
 *   例如: ArrayList继承了AbstractList抽象类,而AbstractList抽象类实现了List接口,那为什么ArrayList还要实现List接口？
 *        这个问题可以参考这个回答:
 *        <href>https://stackoverflow.com/questions/2165204/why-does-linkedhashsete-extend-hashsete-and-implement-sete</href>
 *   给我带来了一个思考:
 *   继承结构里的类用上Lombok等插件或pom依赖的@Data,@AllArgsConstructor,@NoArgsConstructor,@Builder等注解很容易出错,要么编译错误,要么运行错误.
 *   底层框架还是老老实实写setter,getter等方法,构造方法设计好对父类属性的继承.
 *
 */
public class DIPTest {

    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User(1001,"jack",70));
        userList.add(new User(1002,"mary",60));
        userList.add(new User(1003,"tom",100));
        userList.add(new User(1004,"tony",80));
        userList.add(new User(1005,"bob",90));

        PrizeEventController prizeEventController = new PrizeEventController();

        RandomPrizeEvent randomPrizeEvent = new RandomPrizeEvent(1001, "随机抽奖活动", "随机抽奖活动描述");
        List<User> chooseUserListForRandom = prizeEventController.choose(randomPrizeEvent, userList, 3);
        System.out.println(randomPrizeEvent.getName()+"中奖用户:"+chooseUserListForRandom);

        WeightPrizeEvent weightPrizeEvent = new WeightPrizeEvent(1002, "权重抽奖活动", "权重抽奖活动描述");
        List<User> chooseUserListForWeight = prizeEventController.choose(weightPrizeEvent, userList, 3);
        System.out.println(weightPrizeEvent.getName()+"中奖用户:"+chooseUserListForWeight);

    }
}
