package com.ysb.designPattern.principle.lawOfDemeter;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Huang Bangbang
 * @date 2022/4/18 - 09:08
 */
@Data
@AllArgsConstructor
public class Teacher {
    private String name;
    private String clazz;
    private static List<Student> studentList = new ArrayList<>();
    static {
        studentList.add(new Student("mary",80d,3));
        studentList.add(new Student("tom",70d,4));
        studentList.add(new Student("tony",85d,2));
        studentList.add(new Student("jack",90d,1));
    }
    public double getTotalScore(){
        return studentList.stream().map(e->e.getScore()).reduce((x,y)->x+y).orElse(0d);
    }

    public double getAverageScore(){
        return studentList.stream().map(e->e.getScore()).reduce((x,y)->x+y).orElse(0d)/(double)studentList.size();
    }

    public Integer getTotalNum(){
        return studentList.size();
    }
}
