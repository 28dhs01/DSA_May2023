package com.dhruv.dp.pattern2;

import java.util.Arrays;

public class Knapsack01 {
    public static void main(String[] args) {
        int[] wts = {2,5,1,3,4};
        int[] prc = {15,14,10,45,30};
        int bagLimit = 7 ;
        int[][] dp = new int[wts.length+1][bagLimit+1];
        for( int i = 0  ; i< dp.length ; i++ ){
            for( int j = 0 ; j<dp[0].length ; j++ ){
                if( i != 0 && j != 0){
                    if(  wts[i-1] <= j ){
                        int remLmt = j - wts[i-1];
                        dp[i][j] = Math.max(dp[i-1][j],dp[i-1][remLmt]+prc[i-1]);
                    }else {
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }
        for( int[] row: dp){
            System.out.println(Arrays.toString(row));
        }
        System.out.println(dp[wts.length][bagLimit]);
    }
}
