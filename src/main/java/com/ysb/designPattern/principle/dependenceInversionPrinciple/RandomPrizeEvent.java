package com.ysb.designPattern.principle.dependenceInversionPrinciple;

import com.ysb.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Huang Bangbang
 * @date 2022/4/27 - 10:54
 */
public class RandomPrizeEvent extends AbstractPrizeEvent implements PrizeEvent{

    /**
     * 随机抽奖活动
     * @param userList 抽奖用户列表
     * @param count 抽奖用户数
     * @return 中奖用户列表
     */
    @Override
    public List<User> choose(List<User> userList, Integer count) {
        Collections.shuffle(userList);
        List<User> result = new ArrayList<>();
        for (int i =0;i<count;i++){
            result.add(userList.get(i));
        }
        return result;
    }

    public RandomPrizeEvent(Integer id,String name,String description) {
        super(id,name,description);
    }
}
