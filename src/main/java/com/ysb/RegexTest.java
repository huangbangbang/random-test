package com.ysb;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Huang Bangbang
 * @date 2022/9/14 - 11:23
 */
public class RegexTest {
    public static void main(String[] args) {
        String phone = "del18742586171";
        boolean isMobile = isPhone(phone);
        if (isMobile){
            System.out.println(phone +" is a right number");
        }else {
            System.out.println(phone +" is a wrong number");
        }
    }

//    public static boolean isPhone(final String str) {
//        Pattern p1 = null, p2 = null;
//        Matcher m = null;
//        boolean b = false;
//        p1 = Pattern.compile("^[0][1-9]{2,3}-[0-9]{5,10}$");  // 验证带区号的
//        p2 = Pattern.compile("^[1-9]{1}[0-9]{5,8}$");         // 验证没有区号的
//        if (str.length() > 9) {
//            m = p1.matcher(str);
//            b = m.matches();
//        } else {
//            m = p2.matcher(str);
//            b = m.matches();
//        }
//        return b;
//    }

//    public static boolean isMobile(final String str) {
//        Pattern p = null;
//        Matcher m = null;
//        boolean b = false;
//        p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$"); // 验证手机号
//        m = p.matcher(str);
//        b = m.matches();
//        return b;
//    }

    public static boolean isPhone(String phoneNumber) {
        if (StringUtils.isBlank(phoneNumber)){
            return false;
        }
        String regex = "^((13[0-9])|(14(0|[5-7]|9))|(15([0-3]|[5-9]))|(16(2|[5-7]))|(17[0-8])|(18[0-9])|(19([0-3]|[5-9])))\\d{8}$";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(phoneNumber);
        return m.matches();
    }

}
