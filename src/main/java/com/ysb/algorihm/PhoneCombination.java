package com.ysb.algorihm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * @author huangbangbang
 */
public class PhoneCombination {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();

    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList();
        Map<Character,String> phoneMap = new HashMap(){{
            put('2',"abc");
            put('3',"def");
            put('4',"ghi");
            put('5',"jkl");
            put('6',"mno");
            put('7',"pqrs");
            put('8',"tuv");
            put('9',"wxyz");
        }};
        if(digits.equals("")){
            return res;
        }

        backtrace(digits,new StringBuffer(),res,phoneMap);
        return res;

    }

    private void backtrace(String digits, StringBuffer stringBuffer, List<String> res, Map<Character, String> phoneMap) {

        String combination = stringBuffer.toString();
        if (combination.length()==digits.length()){
            res.add(combination);
        }else {
            char c = digits.charAt(combination.length());
            String s = phoneMap.get(c);
            for (int i = 0; i < s.length(); i++) {
                stringBuffer.append(s.charAt(i));
                backtrace(digits,stringBuffer,res,phoneMap);
                stringBuffer.deleteCharAt(i);
            }
        }
    }
}
