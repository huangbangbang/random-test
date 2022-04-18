package com.ysb.designPattern.principle.liskovSubstitutedPrinciple;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Huang Bangbang
 * @date 2022/4/15 - 10:31
 */
@Data
@NoArgsConstructor
@SuperBuilder
public class CashCard extends BankCard{

    @Override
    boolean ruleCheck(BigDecimal amount) {
        return amount.compareTo(BigDecimal.ZERO)>0;
    }

    /**
     * 充值
     * @param sn 订单号
     * @param amount 充值金额
     * @return true 返回订单号 false 返回错误提示
     */
    public String recharge(String sn , BigDecimal amount){
        String flow =  "账户"+this.cardNo+"于"+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))+"充值"+amount+",订单号为"+sn;
        logger.info(flow);
        return this.positive(sn , amount);
    }

    /**
     * 打印贷款或还款金额 （模版方法模式）
     * @param sn 订单号
     * @param amount 金额
     * @param operation 操作 贷款/还款
     */
    public void loanBalancePrint(String sn, BigDecimal amount, String operation) {
    }
    /**
     * 提现
     * @param sn 订单号
     * @param amount 提现金额
     * @return true 返回订单号 false 返回错误提示
     */
    public String withdraw(String sn , BigDecimal amount){
        String flow =  "账户"+this.cardNo+"于"+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))+"提现"+amount+",订单号为"+sn;
        logger.info(flow);
        return this.negative(sn , amount);
    }
}
