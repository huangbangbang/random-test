package com.ysb.designPattern.principle.lsp;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Huang Bangbang
 * @date 2022/4/15 - 13:59
 */
@Data
@SuperBuilder
@NoArgsConstructor
public class CreditCard extends CashCard{
    /**
     * 贷款额度
     */
    private BigDecimal loanAmount;

    /**
     * 贷款
     * @param sn 订单号
     * @param amount 贷款金额
     * @return 订单号 或错误提示
     */
    public String loan(String sn,BigDecimal amount){
        if (ruleCheck(amount)) {
            loanAmount = this.loanAmount.add(amount);
            String flow =  "账户"+this.cardNo+"于"+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))+"贷款"+amount+",订单号为"+sn;
            logger.info(flow);
            String positive = this.positive(sn, amount);
            loanBalancePrint(sn,amount,"贷款");
            return positive;
        }else {
            return "贷款的金额不能为负数";
        }
    }

    /**
     * 打印信用卡的余额等
     * @param sn 订单号
     * @param amount 金额
     * @param operation 操作 贷款/还款
     */
    @Override
    public void loanBalancePrint(String sn, BigDecimal amount, String operation){
        String flow =  "账户"+this.cardNo+"于"+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))+operation+amount+","+operation+"后欠款金额为"+this.loanAmount+"余额为"+this.balance+"订单号为"+sn;
        logger.info(flow);
    }

    /**
     * 还款
     * @param sn 订单号
     * @param amount 还款金额
     * @return 订单号 或者 错误提示
     */
    public String repayment(String sn,BigDecimal amount){
        if (ruleCheck(amount)) {
            if (amount.compareTo(this.loanAmount)>0){
                return "还款的金额不能大于贷款总额";
            }
            loanAmount = this.loanAmount.subtract(amount);
            String flow =  "账户"+this.cardNo+"于"+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))+"还款"+amount+",订单号为"+sn;
            logger.info(flow);
            String negative = this.negative(sn, amount);
            loanBalancePrint(sn,amount,"还款");
            return negative;
        }else {
            return "还款的金额不能为负数";
        }
    }
}
