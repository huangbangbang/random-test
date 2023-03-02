package com.ysb.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Huang Bangbang
 * @date 2023/3/1 - 16:46
 */
public class SocketTest {
    public static void main(String[] args) throws IOException {

        try(Socket socket = new Socket("time-a.mist.gov",13);
            Scanner scanner = new Scanner(socket.getInputStream(), "UTF-8");
        ){
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                System.out.println(line);
            }
        }
        InetAddress[] allByName = InetAddress.getAllByName("baidu.com");
        for (InetAddress inetAddress : allByName) {
            String hostAddress = inetAddress.getHostAddress();
            System.out.println(hostAddress);
        }


    }

}
