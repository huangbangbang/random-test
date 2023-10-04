package com.ysb.algorihm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class StackTest {

    private static final Map<Character,Character> map = new HashMap<Character,Character>(){{
        put('(',')');
        put('[',']');
        put('{','}');
    }};
    public static void main(String[] args) {
        StackTest aa = new StackTest();
        System.out.println(aa.isValid("()[]{}"));

        //System.out.println(aa.simplifyPath("/home//foo/"));
        System.out.println(aa.simplifyPath("/a/./b/../../c/"));
        System.out.println(aa.simplifyPath("/../"));

        LinkedList linkedList = new LinkedList();
        List<Integer> list = new ArrayList<>();
        linkedList.get(1);
    }

    public String simplifyPath(String path) {

        String[] split = path.split("/");
        LinkedList<String> stack = new LinkedList<>();
        for (String s : split) {
            if (s.equals("..")){
                if (stack.size()>0){
                    stack.removeLast();
                }
            }else if (s.equals(".")){

            }else if (s.equals("")){

            }
            else {
                stack.addLast(s);
            }
        }
        String res = "/";

        for (int i = 0; i < stack.size(); i++) {
            if (i!=0){
                res+="/";
            }
            res += stack.get(i);
        }

        return res;
    }
    public boolean isValid(String s) {
        char[] charArray = s.toCharArray();
        if (charArray.length%2!=0){
            return false;
        }
        if (charArray.length>0&&!map.containsKey(charArray[0])){
            return false;
        }

        LinkedList<Character> stack = new LinkedList<Character>(){{add('?');}};
        for (Character c : charArray) {
            if (map.containsKey(c)){
                stack.addLast(c);
            }else if (map.get(stack.removeLast())!=c){
                return false;
            }
        }

        return stack.size()==1;
    }
}
