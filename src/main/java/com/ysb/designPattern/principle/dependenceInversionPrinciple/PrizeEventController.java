package com.ysb.designPattern.principle.dependenceInversionPrinciple;

import com.ysb.User;
import java.util.List;

/**
 * @author Huang Bangbang
 * @date 2022/4/27 - 16:10
 */
public class PrizeEventController {
    /**
     * 随机抽奖活动
     * @param userList 抽奖用户列表
     * @param count 抽奖用户数
     * @return 中奖用户列表
     */
    public List<User> choose(PrizeEvent prizeEvent ,List<User> userList, Integer count) {
        return prizeEvent.choose(userList,count);
    }
}
