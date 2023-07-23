package com.dhruv.dp.leetcode;

import java.util.Arrays;

public class JumpGame3 {
    public static void main(String[] args) {
        int[] arr = {4,2,3,0,3,1,2} ;
        boolean ans = canReach(arr,5) ;
        System.out.println(ans);
    }
    public static boolean canReach(int[] arr, int start) {
        Boolean[] dp = new Boolean[arr.length] ;



//        System.out.println(Arrays.toString(dp));
        return  helper(arr,start,dp);
    }
    static boolean helper(int[] arr, int s , Boolean[] dp ){
        if( s >= dp.length || s<0 ){
            return false ;
        }
        if( arr[s] == 0 ){
            return true ;
        }
        if( dp[s] != null ){
            return dp[s] ;
        }
        dp[s] = false ;
        boolean left = helper(arr,s+arr[s],dp);
        boolean right = helper(arr, s-arr[s],dp);
        return left || right ;
    }
}
