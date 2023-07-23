package com.dhruv.dp.pattern2;

import java.util.Arrays;

public class KnapsackUnbounded {
    public static void main(String[] args) {
        int[] wts = {2,5,1,3,4};
        int[] prc = {15,14,10,45,30};
        int bgLmt = 7 ;
        int[] dp = new int[bgLmt+1] ;
        dp[0] = 0 ;
        for( int i = 1 ; i<dp.length ; i++ ){
            int max = 0 ;
            for( int j = 0 ; j<wts.length ; j++ ){
                if( i >= wts[j] ){
                    int remLmt = i-wts[j] ;
                    int curPrc = prc[j]+dp[remLmt] ;
                    max = Math.max(max,curPrc) ;
                }
            }
            dp[i] = max ;
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(dp[bgLmt]);
    }
}
