package com.ysb.nio;

import cn.hutool.core.io.file.FileMode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

/**
 * @author Huang Bangbang
 * @date 2023/3/3 - 10:20
 */
public class ChannelSource {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/huangbangbang/desktop/aaa.txt");
        FileChannel channel = fileOutputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(20);
        channel.write(ByteBuffer.wrap("i love china".getBytes()));
        channel.read(buffer);
        while (buffer.hasRemaining()){
            System.out.println((char) buffer.get());
        }

//        FileInputStream fileInputStream = new FileInputStream("/Users/huangbangbang/desktop/aaa.txt");
//        channel = fileInputStream.getChannel();
//        channel.write(buffer);

        RandomAccessFile randomAccessFile = new RandomAccessFile("/Users/huangbangbang/desktop/aaa.txt", "rw");
        channel = randomAccessFile.getChannel();
        channel.read(buffer);
        buffer.flip();
        while (buffer.hasRemaining()){
            System.out.print((char) buffer.get());
        }
        channel.close();
    }
}
