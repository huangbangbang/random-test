package com.ysb.enumeration;

/**
 * @author Huang Bangbang
 * @date 2022/6/16 - 18:00
 */
public enum FatherEnum {
    BUY{
        @Override
        public Integer process() {
            System.out.println("BUY do it!");
            return 1;
        }
    },
    SELL{
        @Override
        public Integer process() {
            System.out.println("SELL do it!");
            return 2;
        }
    };

    /**
     * 尝试一下枚举的抽象方法
     * @return
     */
    public abstract Integer process();
}
