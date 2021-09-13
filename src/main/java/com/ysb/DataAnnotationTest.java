package com.ysb;

import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class DataAnnotationTest {
    public static void main(String[] args) {
        User user = new User();
        user.setName("jack");
        user.setNo(12);
        User user1 = new User();
        user1.setName("jack1");
        user1.setNo(13);
        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user1);
        String s = JSONArray.toJSONString(users);
        System.out.println(s);
    }
}
