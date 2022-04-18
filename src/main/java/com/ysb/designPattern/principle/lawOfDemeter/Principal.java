package com.ysb.designPattern.principle.lawOfDemeter;

import lombok.Data;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Huang Bangbang
 * @date 2022/4/18 - 09:53
 */
@Data
public class Principal {
    private Teacher teacher = new Teacher("hary","三年级一班");
    public Map<String,Object> getClassInfo(){
        Integer totalNum = teacher.getTotalNum();
        double totalScore = teacher.getTotalScore();
        double averageScore = teacher.getAverageScore();
        HashMap<String, Object> map = new LinkedHashMap<>(10);
        map.put("teacherName",teacher.getName());
        map.put("clazz",teacher.getClazz());
        map.put("totalNum",totalNum);
        map.put("totalScore",totalScore);
        map.put("averageScore",averageScore);
        return map;
    }
}
