package com.dhruv.dp.leetcode;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int[]coins = {2} ;
        int target = 1 ;
        int ans = coinChange(coins,target);
        System.out.println(ans);
    }
    public static int coinChange(int[] coins, int amount) {
        int [] dp = new int[amount+1] ;
        dp[0] = 0 ;
        for( int amt = 1 ; amt<dp.length ; amt++ ){
            int ways = Integer.MAX_VALUE ;
            for( int coin : coins ){
                if( amt>=coin ){
                    ways = Math.min(dp[amt-coin],ways);
                }
            }
            if( ways != Integer.MAX_VALUE ){
                ways = ways+1 ;
            }else{
                ways = Integer.MAX_VALUE ;
            }
            dp[amt] = ways ;
        }
        if( dp[amount] == Integer.MAX_VALUE ){
            return -1 ;
        }
        return dp[amount] ;
    }
}
