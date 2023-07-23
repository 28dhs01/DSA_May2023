package com.dhruv.dp.pattern2;

import java.util.Arrays;

public class CoinChangePermutation {
    public static void main(String[] args) {
        int [] coins = {2,3,5};
        int target = 7 ;
        int[] dp = new int[target+1];
        dp[0] = 1 ;
        for( int i = 1 ; i < dp.length ; i++ ){
            for( int j = 0 ; j<coins.length ; j++ ){
                if( i-coins[j] >= 0 ){
                    int remAmt = i - coins[j] ;
                    dp[i] = dp[i] + dp[remAmt] ;
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(dp[target]);
    }
}
