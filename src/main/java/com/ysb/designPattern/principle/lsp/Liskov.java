package com.ysb.designPattern.principle.lsp;

import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 * @author Huang Bangbang
 * @date 2022/4/14 - 09:48
 *
 *    对里氏替换原则（liskov substituted principle）的一个理解
 *    抽象类BankCard（银行卡）是子类的模版实现 子类有自己的独特行为 所以考虑抽象类行为的原子性
 *    CreditCard -> CashCard -> BankCard  (继承结构)
 *    CashCard是储蓄卡 有自己的充值,提现行为
 *    CreditCard是信用卡 有自己的贷款和还款行为
 *    用一个LinkedHashMap来存储流水信息 1.可以通过sn查找流水信息 2.利用LinkedHashMap可以保证一个顺序性打印流水信息 (TreeMap可以保证一个大小序)
 *
 *    Subtypes must be substitutable for their base types.
 *    简单来说，子类可以扩展父类的功能，但不能改变父类原有的功能。也就是说：当子类继承父类时，除添加新的方法且完成新增功能外，尽量不要重写父类的方法。这句话包括了四点含义：
 *   1.子类可以实现父类的抽象方法，但不能重写父类的非抽象方法。
 *   2.子类可以有自己独特的方法。
 *   3.当子类的方法重载父类的方法时，方法的前置条件（即方法的输入参数）要比父类的方法更宽松。
 *   4.当子类的方法实现父类的方法（重写、重载或实现抽象方法）时，方法的后置条件（即方法的输出或返回值）要比父类的方法更严格或与父类的方法相等。
 *   CashCard cashCard = new CashCard();
 *   CashCard cashCard = new CreditCard();
 *   两种方式要有一样的结果
 */
public class Liskov {
    public static void main(String[] args) {
//        CashCard cashCard = CashCard.builder()
//                .cardNo("YSB007816")
//                .balance(BigDecimal.ZERO)
//                .logger(LoggerFactory.getLogger(CashCard.class))
//                .build();
//        String rechargeSn = cashCard.recharge("10001", new BigDecimal("10000"));
//        System.out.println("充值后查询流水");
//        cashCard.tradeFlow().forEach((k, v) -> System.out.println(v));
//        System.out.println();
//        String withdrawSn = cashCard.withdraw("10002", new BigDecimal("5000"));
//        System.out.println("充值后查询流水");
//        cashCard.tradeFlow().forEach((k, v) -> System.out.println(v));
//        System.out.println();
//        System.out.println("根据订单号查流水");
//        System.out.println(cashCard.getDetailBySn(rechargeSn));
//        System.out.println(cashCard.getDetailBySn(withdrawSn));
//        System.out.println("======================================================================================================================================");

//        CreditCard creditCard = CreditCard.builder()
//                .cardNo("YSB007816")
//                .balance(BigDecimal.ZERO)
//                .logger(LoggerFactory.getLogger(CreditCard.class))
//                .loanAmount(BigDecimal.ZERO)
//                .build();
//        String loanSn = creditCard.loan("10001", new BigDecimal("10000"));
//        System.out.println("贷款后查询流水");
//        creditCard.tradeFlow().forEach((k, v) -> System.out.println(v));
//        System.out.println();
//        String repaymentSn = creditCard.repayment("10002", new BigDecimal("5000"));
//        System.out.println("还款后查询流水");
//        creditCard.tradeFlow().forEach((k, v) -> System.out.println(v));
//        System.out.println();
//        System.out.println("根据订单号查流水");
//        System.out.println(creditCard.getDetailBySn(loanSn));
//        System.out.println(creditCard.getDetailBySn(repaymentSn));
//        System.out.println("======================================================================================================================================");

        CashCard cashCard = CreditCard.builder()
                .cardNo("YSB007816")
                .balance(BigDecimal.ZERO)
                .logger(LoggerFactory.getLogger(CashCard.class))
                .build();
        String rechargeSn = cashCard.recharge("10001", new BigDecimal("10000"));
        System.out.println("充值后查询流水");
        cashCard.tradeFlow().forEach((k, v) -> System.out.println(v));
        System.out.println();
        String withdrawSn = cashCard.withdraw("10002", new BigDecimal("5000"));
        System.out.println("充值后查询流水");
        cashCard.tradeFlow().forEach((k, v) -> System.out.println(v));
        System.out.println();
        System.out.println("根据订单号查流水");
        System.out.println(cashCard.getDetailBySn(rechargeSn));
        System.out.println(cashCard.getDetailBySn(withdrawSn));
        System.out.println("======================================================================================================================================");
    }
}
