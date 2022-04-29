package com.ysb.designPattern.principle.singleResponsibilityPrinciple;

/**
 * @author Huang Bangbang
 * @date 2022/4/29 - 11:19
 *   对单一职责原则(Single Responsibility Principle,SRP)的一个理解.单一职责原则又称单一功能原则,是面向对象的五个基本原则（SOLID）之一.
 *   它规定一个类应该只有一个发生变化的原因.该原则由罗伯特·C.马丁（Robert C.Martin）在《敏捷软件开发：原则、模式与实践》一书中提出.
 *   如果需要开发的一个功能需求不是一次性的,且随着业务发展的不断变化而变化,那么当一个Class类负责超过两个及以上的职责时,就在需求的不断迭代,实现类持续扩张的情况下,
 *   就会出现难以维护,不好扩展,测试难度大和上线风险高等问题.
 *   所谓的职责就是指类变化的原因,也就是业务需求.如果一个类有多于一个的原因被改变,那么这个类就有超过两个及以上的职责.而单一职责约定一个类应该有且仅有一个改变类的原因.
 */
public class SRPTest {
    public static void main(String[] args) {
        IVideoUserService guestVideoUserService = new GuestVideoUserServiceImpl();
        IVideoUserService ordinaryVideoUserService = new OrdinaryVideoUserServiceImpl();
        IVideoUserService vipVideoUserService = new VIPVideoUserServiceImpl();

        guestVideoUserService.difinition();
        guestVideoUserService.ad();

        ordinaryVideoUserService.difinition();
        ordinaryVideoUserService.ad();

        vipVideoUserService.difinition();
        vipVideoUserService.ad();
    }
}
