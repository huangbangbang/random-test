package com.ysb;

import java.util.TimeZone;

public class TimeZoneTest {
    public static void main(String[] args) {
        String ids[] = TimeZone.getAvailableIDs();
        for(String id: ids) {
            System.out.println(id);
        }
    }
}
