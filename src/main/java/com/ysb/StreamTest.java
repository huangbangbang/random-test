package com.ysb;

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
    }
}
