package com.ysb.designPattern.principle.dependenceInversionPrinciple;

import com.ysb.User;

import java.util.List;

/**
 * @author Huang Bangbang
 * @date 2022/4/27 - 10:41
 * 活动接口
 */
public interface Event {
    /**
     * 活动
     * @param userList 参与活动用户列表
     * @param count 选中活动用户数
     * @return 选中用户列表
     */
    List<User> choose(List<User> userList, Integer count);
}
