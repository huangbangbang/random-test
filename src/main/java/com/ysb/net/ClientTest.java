package com.ysb.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @author Huang Bangbang
 * @date 2023/3/1 - 18:39
 */
public class ClientTest {
    public static void main(String[] args) throws IOException, InterruptedException {

        boolean flag = true;
        while (true){
            Thread.sleep(1000);
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(InetAddress.getLoopbackAddress(),6666));
            OutputStream outputStream = socket.getOutputStream();
            if (flag){
                byte[] message = "hello server".getBytes();
                int length = message.length;
                outputStream.write(length>>8);
                outputStream.write(length);
                outputStream.write(1);
                outputStream.write(message);
                flag = false;
            }else {
                byte[] heartbeat = "i  alive".getBytes();
                int heartbeatLength = heartbeat.length;
                outputStream.write(heartbeatLength>>8);
                outputStream.write(heartbeatLength);
                outputStream.write(255);
                outputStream.write(heartbeat);
                flag = true;
            }
        }

    }
}
