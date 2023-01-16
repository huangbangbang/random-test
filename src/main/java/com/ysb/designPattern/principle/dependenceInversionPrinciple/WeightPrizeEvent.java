package com.ysb.designPattern.principle.dependenceInversionPrinciple;

import com.ysb.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Huang Bangbang
 * @date 2022/4/27 - 11:20
 */
public class WeightPrizeEvent extends AbstractPrizeEvent implements PrizeEvent{
    @Override
    public List<User> choose(List<User> userList, Integer count) {
        //userList = userList.stream().sorted((o1, o2) -> o2.getWeight()-o1.getWeight()).collect(Collectors.toList());
        List<User> result = new ArrayList<>();
        for (int i =0 ;i < count ; i++){
            result.add(userList.get(i));
        }
        return result;
    }

    public WeightPrizeEvent(Integer id,String name,String description) {
        super(id,name,description);
    }
}
