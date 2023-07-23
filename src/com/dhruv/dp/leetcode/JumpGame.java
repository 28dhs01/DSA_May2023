package com.dhruv.dp.leetcode;

public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4} ;
        boolean res = canJump(nums) ;
        System.out.println(res);
    }
    public static boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length] ;
        dp[dp.length-1] = true ;
        for( int i = dp.length-2 ; i>=0 ; i-- ){
            dp[i] = false ;
            for( int j = 1 ; j<=nums[i] && i+j<dp.length ; j++ ){
                if( dp[i+j] == true ){
                    dp[i] = true;
                    break ;
                }
            }
        }
        return dp[0] ;
    }
}
