package com.ysb.designPattern.principle.lawOfDemeter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author Huang Bangbang
 * @date 2022/4/18 - 10:05
 *  对迪米特法则（Law of Demeter,LoD）的一个理解 迪米特法则又称最少知道原则（Least Knowledge Principle,LKP）
 *  一个类对于其他类知道的越少越好,就是说一个对象应当对其他对象有尽可能少的了解,只和朋友通信,不和陌生人说话
 *  talk only to your immediate friends
 *  其含义是：如果两个软件实体无须直接通信,那么就不应当发生直接的相互调用,可以通过第三方转发该调用.其目的是降低类之间的耦合度,提高模块的相对独立性
 *  迪米特法则中的"朋友"是指:当前对象本身、当前对象的成员对象、当前对象所创建的对象、当前对象的方法参数等,这些对象同当前对象存在关联、聚合或组合关系,可以直接访问这些对象的方法.
 *
 *  迪米特法则要求限制软件实体之间通信的宽度和深度,正确使用迪米特法则将有以下两个优点:
 *  1.降低了类之间的耦合度，提高了模块的相对独立性。
 *  2.由于亲合度降低，从而提高了类的可复用率和系统的扩展性。
 *  但是,过度使用迪米特法则会使系统产生大量的中介类,从而增加系统的复杂性,使模块之间的通信效率降低.所以,在釆用迪米特法则时需要反复权衡,确保高内聚和低耦合的同时,保证系统的结构清晰.
 *
 *  迪米特法则的实现方法
 *      从迪米特法则的定义和特点可知,它强调以下两点:
 *      1.从依赖者的角度来说,只依赖应该依赖的对象.
 *      2.从被依赖者的角度说,只暴露应该暴露的方法.
 *
 *      所以,在运用迪米特法则时要注意以下 6 点。
 *      1.在类的划分上，应该创建弱耦合的类。类与类之间的耦合越弱，就越有利于实现可复用的目标。
 *      2.在类的结构设计上，尽量降低类成员的访问权限。
 *      3.在类的设计上，优先考虑将一个类设置成不变类。
 *      4.在对其他类的引用上，将引用其他对象的次数降到最低。
 *      5.不暴露类的属性成员，而应该提供相应的访问器（set 和 get 方法）。
 *      6.谨慎使用序列化（Serializable）功能。
 */
public class DemeterTest {
    public static void main(String[] args) {
        Principal principal = new Principal();
        Map<String, Object> classInfo = principal.getClassInfo();
        System.out.println(classInfo);

        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        Stream<Integer> sorted = list.stream().sorted();
        System.out.println(sorted);
    }
}
