package com.ysb.algorihm;

public class BitOperations {
    public static void main(String[] args) {
        /**
         * 对于位运算的一些学习和思考
         */

        //与运算（保留低位）
        //想保留前n位 则 &(2^n-1)
        System.out.println(16&15);
        //想保留第n位 则 &2^(n-1)
        System.out.println(15&2);

        //或运算 （在高位可以做一些操作)
        //有些变量的高位一直都没用,处于空闲状态,结合实际的业务可以将其利用起来
        // int a 代表一个人的年龄 ，但是一个人的年龄不会超过1000，int却占了4个字节，尝试用高位记录一下性别 0-男 1-女
        // 2^10 = 1024 尝试用第十一位记录性别

        int a = 26;
        //最高位是0，默认是男，不用处理

        int b = 25;
        b |= (1<<10);

        int bAge = b & ((1 << 10)-1);
        if ((b>>=10) == 1){
            System.out.println("一位年龄"+bAge+"岁的女同志");
        }else {
            System.out.println("一位年龄"+bAge+"岁的男同志");
        }

        int aAge = a & ((1 << 10)-1);
        if ((b>>=10) == 1){
            System.out.println("一位年龄"+aAge+"岁的女同志");
        }else {
            System.out.println("一位年龄"+aAge+"岁的男同志");
        }



        // 位移运算 (cpu计算快,配合其他的位运算)
        // *100 可以变成多个移位运算的和 (左移右移运算符的优先级比较低)
        // *100 -> *( 64 + 32 + 4) -> *( 2^6 + 2^5 + 2^2)  -> *( (1<<6) + (1<<5) + (1<<2) )
        System.out.println(1*( (1 <<6) + (1<<5 )+ (1<<2)));
    }
}
