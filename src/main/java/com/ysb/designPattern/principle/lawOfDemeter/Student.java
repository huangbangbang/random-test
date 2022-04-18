package com.ysb.designPattern.principle.lawOfDemeter;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.HashMap;

/**
 * @author Huang Bangbang
 * @date 2022/4/18 - 09:07
 */
@Data
@AllArgsConstructor
public class Student {
    private String name;
    private Double score;
    private Integer ranking;

    public static void main(String[] args) {
        Student student = new Student("jack", 100d, 20);
        String s = JSON.toJSONString(student);
        System.out.println(student);
        System.out.println(s);
        HashMap<String, String> map = new HashMap<>();
        map.put("name","jack");
        System.out.println(map);
        System.out.println(JSON.toJSONString(map));

    }
}
