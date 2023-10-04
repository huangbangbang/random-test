package com.ysb.algorihm;

import java.util.Arrays;

public class Test9 {
    public static void main(String[] args) {
        Test9 aa = new Test9();
        int[] nums = {4, 3, 2, 1,8,9,12,4,5,7};
        int[] sortedNums = aa.mergeSort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(sortedNums));
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
