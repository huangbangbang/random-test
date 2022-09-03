package com.ysb;

import org.apache.commons.lang3.StringUtils;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        byte[] a  ={65, 66, 67, 68};
        String s = new String(a);
        System.out.println(s);
        System.out.println(a[0]);

        Stream.of("three", "four","three", "four","three", "four","three", "four","three", "four","one", "two", "three", "four")
                .skip(10)
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());
        System.out.println(LocalTime.MAX.truncatedTo(ChronoUnit.SECONDS));
        System.out.println(LocalTime.MAX.withNano(0));
        System.out.println(LocalDate.now().atTime(LocalTime.MAX.withNano(0)));
        System.out.println(LocalTime.MIN);
        System.out.println(LocalTime.MIDNIGHT);

        String[] strings = new String("adkj").split(",");
        System.out.println(Arrays.toString(strings));

        Integer integer = 1==9?1:0;
        System.out.println(integer);

        for (String s1 : "-1".split(",")) {
            System.out.println(s1);
        }

        System.out.println("\uD834\uDD1E".length());

        Duration between = Duration.between(LocalDateTime.of(2022, 9, 3, 0, 0, 0), LocalDateTime.now());
        System.out.println(between.toDays());

        String[] strArray = new String[]{"jack"};
        Object[] objectArray = strArray;
        String jack =(String) objectArray[0];
        System.out.println(jack);


        HashMap<Integer, Long> map = new HashMap<>();
        map.put(1318089,Long.parseLong("3"));
        Long value = map.get((long) 1318089);
        System.out.println(value);

        int[][] array = new int[10][20];
        for (int i =0 ;i<20;i++){
            for (int j=0;j<10;j++){
                array[j][i] = 1;
            }
        }
        for (int[] ints : array) {
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        }
        System.out.println("=======================二维数组的另一种赋值方式======================");
        for (int i =0 ;i<20;i++){
            for (int j=0;j<10;j++){
                array[j][i] = 1;
            }
        }
        for (int[] ints : array) {
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        }
    }

}
