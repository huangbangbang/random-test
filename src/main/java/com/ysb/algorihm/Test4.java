package com.ysb.algorihm;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.SortedMap;
import java.util.TreeMap;

public class Test4 {
    public static void main(String[] args) {
        Test4 aa = new Test4();

        ListNode l1 = new ListNode(9);
        ListNode l1Index = l1;
        l1Index.next = new ListNode(9);
        l1Index = l1Index.next;
        l1Index.next = new ListNode(9);
        l1Index = l1Index.next;
        l1Index.next = new ListNode(9);
        l1Index = l1Index.next;
        l1Index.next = new ListNode(9);
        l1Index = l1Index.next;
        l1Index.next = new ListNode(9);
        l1Index = l1Index.next;
        l1Index.next = new ListNode(9);

        ListNode l2 = new ListNode(9);
        ListNode l2Index = l2;
        l2Index.next = new ListNode(9);
        l2Index = l2Index.next;
        l2Index.next = new ListNode(9);
        l2Index = l2Index.next;
        l2Index.next = new ListNode(9);


        ListNode l3 = new ListNode(1);
        ListNode l3Index = l3;
        l3Index.next = new ListNode(2);
        l3Index = l3Index.next;
        l3Index.next = new ListNode(3);
        l3Index = l3Index.next;
        l3Index.next = new ListNode(4);
        l3Index = l3Index.next;
        l3Index.next = new ListNode(5);


        Queue<TreeNode> queue = new LinkedList<>();
        
        System.out.println(Math.pow(2, 5));
        queue.add(new TreeNode(2));

        System.out.println((double)(13.5)/ (2));




    }



    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}