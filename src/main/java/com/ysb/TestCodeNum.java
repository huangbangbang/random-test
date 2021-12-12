package com.ysb;

import java.io.*;

public class TestCodeNum {

    public static void main(String[] args) throws IOException {
        // java代码
        int java_num = getProjectFileNumber(new File("D:\\IdeaProjects\\random-test\\src\\main\\java\\com\\ysb"), ".java");

        // resource目录
        // xml
        int xml_num = getProjectFileNumber(new File("D:\\NewIdeaProjects\\clinic-diag-admin\\src\\main\\resources\\mapper"), ".xml");
        // properties
        int properties_num = getProjectFileNumber(new File("D:\\lw\\work_space\\yxhd\\lcs\\lcs-service\\src\\main"), ".properties");
        System.out.println("java:" + java_num);
        System.out.println("xml:" + xml_num);
        System.out.println("properties:" + properties_num);
        System.out.println("total:" + (java_num + xml_num + properties_num));

    }

    private static int getProjectFileNumber(File file, String endsWith) throws IOException{
        int number = 0;
        if (file.exists()) {
            if (file.isDirectory()) {
                for (File subFile : file.listFiles()) {
                    number += getProjectFileNumber(subFile, endsWith);
                }
            } else if (file.isFile() && file.getName().endsWith(endsWith)) {
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                while (br.readLine() != null) {
                    number += 1;
                }
            } else {
                System.out.println("===" + file.getAbsolutePath());
            }
        }
        return number;
    }

}