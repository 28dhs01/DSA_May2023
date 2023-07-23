package com.dhruv.dp.leetcode;

import java.util.Arrays;

public class JumpGame2 {
    public static void main(String[] args) {
        int[] nums = {2,3,0,1,4} ;
        int ans = jump(nums);
        System.out.println(ans);
    }
    public static int jump(int[] nums) {
        Integer[] dp = new Integer[nums.length] ;
        dp[dp.length-1] = 0 ;
        for( int i = dp.length-2 ; i>=0 ; i-- ){
            int min = Integer.MAX_VALUE ;
            for( int j = 1 ; j<=nums[i] && i+j<dp.length ; j++ ){
                if( dp[i+j] != null ){
                    min = Math.min(min,dp[i+j]) ;
                }
            }
            if( min != Integer.MAX_VALUE ){
                dp[i] = min+1 ;
            }

        }
        return dp[0] ;
    }
}
