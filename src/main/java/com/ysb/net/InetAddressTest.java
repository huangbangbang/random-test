package com.ysb.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author Huang Bangbang
 * @date 2023/3/1 - 16:46
 */
public class InetAddressTest {
    public static void main(String[] args) throws IOException {
        InetAddress inetAddress = InetAddress.getByName("www.baidu.com");
        System.out.println(inetAddress.getHostAddress());System.out.println();
    }
}
