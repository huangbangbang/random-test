package com.ysb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author huangbangbang
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private Integer no;
    private String name;
    private Integer weight;

    static ArrayList<ArrayList<BigDecimal>> lists = new ArrayList<>();
    static LinkedList<BigDecimal> fuck = new LinkedList<>();

    public static void main(String[] args) {

        BigDecimal result = new BigDecimal("541177.21");
        List<BigDecimal> bigDecimalList = new ArrayList<>();
        bigDecimalList.add(new BigDecimal("75163.07"));
        bigDecimalList.add(new BigDecimal("143897.5"));
        bigDecimalList.add(new BigDecimal("299722.23"));
        bigDecimalList.add(new BigDecimal("162766.03"));
        bigDecimalList.add(new BigDecimal("179270.74"));
        bigDecimalList.add(new BigDecimal("67337.13"));
        bigDecimalList.add(new BigDecimal("40042.8"));
        bigDecimalList.add(new BigDecimal("196488.09"));
        bigDecimalList.add(new BigDecimal("61277.64"));
        bigDecimalList.add(new BigDecimal("21945"));
        bigDecimalList.sort(Comparator.naturalOrder());

        //100是查找和为100的数字，0是数组开始位置，arr.length-1是数组结束位置
        findList(result,bigDecimalList,0,bigDecimalList.size()-1);


        for(ArrayList list :lists){
            System.out.println(list);
        }

    }


    //sun要找的和为定值的数，arr数组是找数的范围，start是标记当前递归的下标，end是用来跟start判断的如果小于start就结束递归
    public static void findList(BigDecimal sum, List<BigDecimal> arr, int start, int end) {
        if (start >= end) {
            return;
        }

        if (sum.subtract(arr.get(start)).doubleValue()>-500&&sum.subtract(arr.get(start)).doubleValue()<500) {
            BigDecimal bigDecimal  = BigDecimal.ZERO;
            ArrayList<BigDecimal> list = new ArrayList<>();
            for(BigDecimal num :fuck){
                list.add(num);
                bigDecimal = bigDecimal.add(num);
            }
            list.add(arr.get(start));
            bigDecimal = bigDecimal.add(arr.get(start));
            System.out.println(bigDecimal);
            System.out.println(list);
            lists.add(list);
        } else {
            if (sum.subtract(arr.get(start)).compareTo(BigDecimal.ZERO)>0) {
                fuck.add(arr.get(start));
                findList(sum.subtract(arr.get(start)), arr, start + 1, end);
                fuck.remove(fuck.size()-1);
            }
            findList(sum, arr, start + 1, end);
        }
    }


}


