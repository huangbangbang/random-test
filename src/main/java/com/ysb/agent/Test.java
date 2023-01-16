package com.ysb.agent;

import com.ysb.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Huang Bangbang
 * @date 2022/5/9 - 16:30
 */
public class Test {
    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("10.250");
        BigDecimal stripTrailingZeros = bigDecimal.stripTrailingZeros();
        System.out.println(stripTrailingZeros);
        System.out.println(bigDecimal.stripTrailingZeros() + "yuan");

        User user1 = new User(111,"jack",1);
        User user2 = new User(111,"jwack",1);
        User user3 = new User(111,"jacwk",1);
        User user4 = new User(111,"jeack",1);
        User user5 = new User(111,"jacfk",1);

        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
        List<Integer> collect1 = userList.stream().distinct().map(e -> e.getNo()).collect(Collectors.toList());
        List<Integer> collect2 = userList.stream().map(e -> e.getNo()).distinct().collect(Collectors.toList());
        System.out.println(collect1);
        System.out.println(collect2);

        System.out.println(BigDecimal.ZERO.equals(new BigDecimal(0.0)));
    }
}
