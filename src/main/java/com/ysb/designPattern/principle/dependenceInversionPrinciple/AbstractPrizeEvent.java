package com.ysb.designPattern.principle.dependenceInversionPrinciple;

/**
 * @author Huang Bangbang
 * @date 2022/4/27 - 16:18
 */

public abstract class AbstractPrizeEvent extends AbstractEvent implements PrizeEvent{
    public AbstractPrizeEvent(Integer id,String name,String description) {
        super(id,name,description);
    }
}
