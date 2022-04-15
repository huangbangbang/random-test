package com.ysb.designPattern.principle.lsp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * @author Huang Bangbang
 * @date 2022/4/15 - 09:54
 */
@Data
@NoArgsConstructor
@SuperBuilder
public abstract class BankCard {

    protected Logger logger = LoggerFactory.getLogger(BankCard.class);

    protected final Map<String, String> map = new LinkedHashMap<>();
    /**
     * 卡号
     */
    protected String cardNo;
    /**
     * 余额
     */
    protected BigDecimal balance;

    /**
     * 规则校验
     * @param amount
     * @return
     */
    abstract boolean ruleCheck(BigDecimal amount);

    /**
     *进款
     * @param sn 订单号
     * @param amount 存款金额
     * @return true 返回订单号 false 返回错误提示
     */
    public String positive(String sn , BigDecimal amount) {
        if (ruleCheck(amount)) {
            balance = this.balance.add(amount);
            String flow =  "账户"+this.cardNo+"于"+LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))+"进款"+amount+",进款后余额为"+this.balance+",订单号为"+sn;
            logger.info(flow);
            map.put(sn,flow);
            return sn;
        }else {
            return "存款的金额不能为负数";
        }
    }

    /**
     *出款
     * @param sn 订单号
     * @param amount 出款金额
     * @return true 返回订单号 false 返回错误提示
     */
    public String negative(String sn , BigDecimal amount) {
        if (ruleCheck(amount)) {
            if (this.balance.compareTo(amount)>0){
                balance = this.balance.subtract(amount);
                String flow =  "账户"+this.cardNo+"于"+LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))+"出款"+amount+",出款后余额为"+this.balance+",订单号为"+sn;
                logger.info(flow);
                map.put(sn,flow);
                return sn;
            }else {
                logger.error("出款的金额大于余额");
                return "出款的金额大于余额";
            }
        }else {
            return "出款的金额不能为负数";
        }
    }

    /**
     * 查询所有流水
     * @return 流水
     */
    public Map<String, String> tradeFlow(){
        return  map;
    }

    /**
     * 根据订单号查询流水
     * @param sn 订单号
     * @return 流水
     */
    public String getDetailBySn(String sn){
        if (null!=map.get(sn)){
            return map.get(sn);
        }else {
            return "不存在的订单号";
        }
    }
}
