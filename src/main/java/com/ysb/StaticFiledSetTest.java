package com.ysb;

import lombok.Value;

public class StaticFiledSetTest {
    private int no;
    private static String name;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public  String getName() {
        return name;
    }

    public  void setName(String name) {
        StaticFiledSetTest.name = name;
    }
}
