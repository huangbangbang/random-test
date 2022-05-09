package com.ysb.builderAnnotation;


/**
 * @author Huang Bangbang
 * @date 2022/5/9 - 15:49
 *    一时兴起,手写@Builder注解的反射生成的代码
 */
public class Test {
    public static void main(String[] args) {
        User user = User.builder()
                .id(1001)
                .name("jack")
                .build();
        System.out.println(user);
    }
}
