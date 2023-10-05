package com.ysb.algorihm;

import java.util.Arrays;
import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;

public class Test9 {
    public static void main(String[] args) {
        Test9 aa = new Test9();
        int[] nums = {4, 3, 2, 1,8,9,12,4,5,7};
        //int[] sortedNums = aa.mergeSort(nums, 0, nums.length-1);
        //System.out.println(Arrays.toString(sortedNums));

        int[] copy = nums;
        int[] ints = aa.quickSort(nums);
        System.out.println(Arrays.toString(ints));

        System.out.println("===========");
        int[] num1 = new int[1_0000_0000];
        for (int i = 0; i < num1.length; i++) {
            num1[i] = new Random().nextInt(1_0000_0000);
        }

        long start = System.currentTimeMillis();
        aa.quickSort(num1,0,num1.length-1);
        long end = System.currentTimeMillis();
        long res = (end - start) ;
        System.out.println(res);

    }

    public int[] quickSort(int[] nums){
        quickSort(nums,0,nums.length-1);
        return nums;
    }

    private void quickSort(int[] nums ,int begin ,int end){
        if (begin>=end){
            return ;
        }
        int left = begin;
        int right = end;
        int key = nums[begin];
        while (left<right){

            while (nums[right]>=key && right>left){
                right--;
            }
            nums[left] = nums[right];
            while (nums[left]<=key && left<right){
                left++;
            }
            nums[right] = nums[left];


        }
        nums[left] = key;
        quickSort(nums,begin,left-1);
        quickSort(nums,right+1,end);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int left = (m+n+1)/2;
        int right = (m+n+2)/2;
        int kth = getKth(nums1, 0, n - 1, nums2, 0, m - 1, left);
        int a = getKth(nums1,0,n-1,nums2,0,m-1,right);
        return 5;
    }
    private int getKth(int[] nums1,int start1,int end1, int[] nums2,int start2, int end2,int k){

        int len1 = end1 - start1 +1;
        int len2 = end2 - start2 +1;

        if(len1>len2){
            return getKth(nums2,start2,end2,nums1,start1,end1,k);
        }
        if(len1==0){
            return nums2[start2+k-1];
        }

        if(k==1){
            return Math.min(nums1[start1],nums2[start2]);
        }

        int i = start1 + Math.min(len1,k/2)-1;
        int j = start2 + Math.min(len2,k/2)-1;

        if(nums1[i]>nums2[j]){
            return getKth(nums1,start1,end1,nums2,j+1,end2,k-(j-start2+1));
        }else{
            return getKth(nums1,i+1,end1,nums2,start2,end2,k-(i-start1+1));
        }


    }


    public int[] mergeSort(int[] nums,int begin,int end){

        if (begin==end){
            return new int[]{nums[begin]};
        }

        int[] left = mergeSort(nums,begin,(begin+end)/2);
        int[] right = mergeSort(nums,(begin+end)/2+1,end);

        int[] res = new int[left.length+right.length];
        int j =0 ;
        int k = 0;
        for (int i = 0; i < res.length; i++) {
            if (j<left.length && k<right.length){
                if (left[j]<right[k]){
                    res[i] = left[j];
                    j++;
                }else {
                    res[i] = right[k];
                    k++;
                }
            }else {
                if (j==left.length){
                    res[i] = right[k];
                    k++;
                }else {
                    res[i] = left[j];
                    j++;
                }
            }


        }
        return res;
    }
}
