package com.dhruv.dp.pattern2;

import java.util.Arrays;

public class CoinChangeCombination {
    public static void main(String[] args) {
        int [] coins = {2,3,5};
        int target = 7 ;
        int[] dp = new int[target+1];
        dp[0] = 1 ;
        for( int i = 0 ; i < coins.length ; i++ ){
            for ( int j = coins[i] ; j<dp.length ; j++ ){
                int remainingTarget = j - coins[i] ;
                dp[j] = dp[j] + dp[remainingTarget] ;
            }
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(dp[target]);
    }
}
