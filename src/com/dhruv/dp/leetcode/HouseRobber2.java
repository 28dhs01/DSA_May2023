package com.dhruv.dp.leetcode;

import java.util.Arrays;

public class HouseRobber2 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1} ;
        int ans = rob(nums) ;
        System.out.println(ans);
    }
    public static int rob(int[] nums) {
        if( nums.length == 1 ){
            return nums[0] ;
        }
        if( nums.length == 2 ){
            return Math.max(nums[0],nums[1]) ;
        }
        int ans1 = helper( nums, 0, nums.length-2 );
        int ans2 = helper(nums, 1, nums.length-1) ;
        return Math.max(ans1,ans2) ;
    }
    static int helper( int [] nums , int s , int e ){
        int[] dp = new int [nums.length-1] ;
        dp[0] = nums[s] ;
        dp[1] = Math.max(nums[s],nums[s+1]);
        for( int i = 2 ; i<dp.length ; i++ ){
            dp[i] = Math.max(dp[i-1],nums[s+i]+dp[i-2]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[dp.length-1] ;
    }
}
