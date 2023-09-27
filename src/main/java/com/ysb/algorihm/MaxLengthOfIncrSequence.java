package com.ysb.algorihm;

import java.util.Arrays;

public class MaxLengthOfIncrSequence {
    public static void main(String[] args) {
        int i = maxLengthOfIncrSequence(new int[]{1,3,5,7});
        System.out.println(i);
    }

    private static int maxLengthOfIncrSequence(int[] nums){
//
//        int length = intArray.length;
//        if (length <= 1){
//            return length;
//        }
////        int result = 0;
////        int[] maxArray = new int[length];
////        maxArray[0] = 1;
//        int result = 1;
//
//        for (int i = 1;i<length;i++){
//            if (intArray[i] > intArray[i-1]) {
//                //maxArray[i] = maxArray[i-1]+1;
//                result++;
//            }else {
//                //maxArray[i] = maxArray[i-1];
//            }
//
//            //result = Math.max(maxArray[i],maxArray[i-1]);
//        }
//        return result;

        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        //初始化就是边界情况
        dp[0] = 1;
        int maxans = 1;
        //自底向上遍历
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            //从下标0到i遍历
            for (int j = 0; j < i; j++) {
                //找到前面比nums[i]小的数nums[j],即有dp[i]= dp[j]+1
                if (nums[j] < nums[i]) {
                    //因为会有多个小于nums[i]的数，也就是会存在多种组合了嘛，我们就取最大放到dp[i]
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            //求出dp[i]后，dp最大那个就是nums的最长递增子序列啦
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;

    }
}
