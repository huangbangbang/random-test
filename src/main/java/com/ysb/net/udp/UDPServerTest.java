package com.ysb.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author Huang Bangbang
 * @date 2023/3/2 - 14:23
 */
public class UDPServerTest {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(7777);
        byte[] bytes = new byte[1024*1024];
        while (true){
            DatagramPacket datagramPacket = new DatagramPacket(bytes,0,bytes.length);
            socket.receive(datagramPacket);
            byte[] data = datagramPacket.getData();
            int length = datagramPacket.getLength();
            System.out.println(new String(data,0,length));
        }
    }
}
