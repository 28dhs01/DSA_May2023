package com.dhruv.dp.leetcode;

public class fibonacci {
    public static void main(String[] args) {
        int ans = fib(5) ;
        System.out.println(ans);
    }
    public static int fib(int n) {
        if( n == 0 ){
            return 0 ;
        }
        int[] dp = new int[n+1] ;
        dp[0] = 0 ;
        dp[1] = 1 ;
        return helper( n,dp );
    }
    static int helper( int n, int[] dp ){
        if( n<=1 ){
            return n ;
        }
        if( dp[n] != 0 ){
            return dp[n] ;
        }
        int lft = helper(n-1,dp);
        int rgt = helper(n-2,dp);
        dp[n] = lft+rgt ;
        return lft+rgt ;
    }
}
