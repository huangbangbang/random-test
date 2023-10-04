package com.ysb.algorihm;

import java.util.LinkedList;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

class MinStack {

    private LinkedList<Integer> linkedList;
    private SortedMap<Integer,Integer> sortedMap;

    public static void main(String[] args) {
//        SortedMap<Integer,Integer> sortedMap = new TreeMap();
//        sortedMap.put(100,2);
//        sortedMap.put(3,2);
//        sortedMap.put(2,2);
//        System.out.println(sortedMap.firstKey());
//        sortedMap.remove(2);
//        System.out.println(sortedMap.firstKey());
//
//        SortedSet sortedSet = new TreeSet();
//        sortedSet.add(100);
//        sortedSet.add(1);
//        sortedSet.add(1);
//        sortedSet.add(10);
//        System.out.println(sortedSet.first());
//        sortedSet.remove(1);
//        System.out.println(sortedSet.first());

        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        minStack.push(3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());

    }
    public MinStack() {
        linkedList = new LinkedList<>();
        sortedMap = new TreeMap();
    }

    public void push(int val) {
        linkedList.addLast(val);
        sortedMap.put(val,sortedMap.getOrDefault(val,0)+1);
    }

    public void pop() {
        Integer last = linkedList.getLast();
        linkedList.removeLast();
        sortedMap.put(last,sortedMap.get(last)-1);
        if (sortedMap.get(last)==0){
            sortedMap.remove(last);
        }
    }

    public int top() {

        return linkedList.getLast();
    }

    public int getMin() {

        return sortedMap.firstKey();
    }
}
