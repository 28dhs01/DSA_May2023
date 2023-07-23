package com.dhruv.dp.leetcode;

public class CoinChange2 {
    public static void main(String[] args) {
        int[] coins = {1,2,5} ;
        int amount = 5 ;
        int ans = change(amount,coins);
        System.out.println(ans);
    }
    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount+1] ;
        dp[0] = 1 ;
        for( int coin: coins ){
            for( int target = 1 ; target<dp.length ; target++ ){
                if( coin <= target ){
                    dp[target] = dp[target] + dp[target-coin];
                }
            }
        }
        return dp[amount] ;
    }
}
