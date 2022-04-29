package com.ysb;

import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;

public class JsonFormat {
    public static void main(String[] args) throws JsonProcessingException {
        User user1 = new User(1,"jack",1);
        User user2 = new User(2,"mary",2);
        ArrayList<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(user1.getNo(),user1.getName());
        hashMap.put(user2.getNo(),user2.getName());
        System.out.println(new ObjectMapper().writeValueAsString(user1));
        System.out.println(new ObjectMapper().writeValueAsString(user2));
        System.out.println(new ObjectMapper().writeValueAsString(list));
        System.out.println(new ObjectMapper().writeValueAsString(hashMap));
        System.out.println("===================================================");
        System.out.println(JSONUtil.toJsonStr(hashMap));
    }
}
