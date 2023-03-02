package com.ysb.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @author Huang Bangbang
 * @date 2023/3/2 - 14:24
 */
public class UDPClientTest {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        while (true){
            byte[] bytes = "hello udp".getBytes();
            DatagramPacket datagramPacket = new DatagramPacket(bytes,0,bytes.length, InetAddress.getLocalHost(),7777);
            socket.send(datagramPacket);
        }
    }
}
