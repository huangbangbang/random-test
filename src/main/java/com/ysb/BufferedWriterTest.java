package com.ysb;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterTest {

    public static void main(String[] args) throws IOException {
        //创建一个字符写入流对象。
        FileWriter fw = new FileWriter("buf.txt");
        //为了提高字符写入流效率。加入了缓冲技术。
        //只要将需要被提高效率的流对象作为参数传递给缓冲区的构造函数即可。
        BufferedWriter bw = new BufferedWriter(fw);
        char[] c = {'a', 'b', 'c', 'd', 'e'};
        bw.write(c, 0, 4);

        //换行
        bw.newLine();

        //再次写入
        bw.write(c, 2, 2);

        //刷新流
        bw.flush();
        //其实关闭缓冲区，就是在关闭缓冲区中的流对象。
        bw.close();
    }

}
