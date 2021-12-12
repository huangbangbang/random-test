package com.ysb;

import java.util.ArrayList;

public class CollectionRelation {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();

        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);

        list2.add(3);
        list2.add(4);
        list2.add(5);
        list2.add(6);

        //两个集合相加
        /*list1.addAll(list2);
        System.out.println(list1);*/


        //两个集合相减,也就是求差集
        /*list1.removeAll(list2);
        System.out.println(list1);
        list2.removeAll(list1);
        System.out.println(list2);*/


        //两个集合求交集
        /*list1.retainAll(list2);
        System.out.println(list1);*/
        /*list2.retainAll(list1);
        System.out.println(list2);*/


        //两个集合求并集(两个集合相加,再减去他们的交集)
        //方法1 B-A 加上 A
//        list2.removeAll(list1);
//        list1.addAll(list2);
//        System.out.println(list1);
        //方法2:两集合相加,利用流去重
//        list1.addAll(list2);
//        list1 = list1.stream().distinct().collect(Collectors.toList());
//        list1 = list1.stream().filter(s->s>2).distinct().collect(Collectors.toList());
//        System.out.println(list1);



        //求对称差
        //方法1:先相加,再减交集
//        List<Integer> list3 =(ArrayList<Integer>) list1.clone();
//        list1.addAll(list2);
//        list3.retainAll(list2);
//        list1.removeAll(list3);
//        System.out.println(list1);
        //方法2:先互相求差集,再相加
//        List<Integer> list3 =(ArrayList<Integer>) list1.clone();
//        list1.removeAll(list2);
//        list2.removeAll(list3);
//        list1.addAll(list2);
//        System.out.println(list1);
    }
}
