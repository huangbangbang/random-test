package com.ysb.designPattern.principle.dependenceInversionPrinciple;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author Huang Bangbang
 * @date 2022/4/27 - 10:23
 * 活动接口
 */
@Data
public abstract class AbstractEvent implements Event{

    private Integer id;

    private String name;

    private String description;

    /**
     * 打印活动详情
     */
    protected void printEventDetail(){
        System.out.println("活动名称是:"+name+",活动说明:"+description);
    }

    public AbstractEvent(Integer id,String name,String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

}
