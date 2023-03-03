package com.ysb.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Huang Bangbang
 * @date 2023/3/1 - 18:46
 */
public class ServerTest {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket();
        server.bind(new InetSocketAddress(6666));
        while (true){
            Socket socket = server.accept();
            //System.out.println("connecting thread id = "+ Thread.currentThread().getId());
            InputStream inputStream = socket.getInputStream();
            int first = inputStream.read();
            if (first==-1){
                break;
            }
            int second = inputStream.read();
            // 0 开头是消息包 1开头是心跳包
            int third = inputStream.read();
            int length = (first << 8) + second;
            byte[] buf = new byte[length];
            String messageType = "";
            if (third > 127 ){
                messageType = "heartbeat package";
            }else {
                messageType = "message package";
            }
            inputStream.read(buf);
            System.out.println(messageType +" : "+ new String(buf));
            socket.close();
        }

    }
}
