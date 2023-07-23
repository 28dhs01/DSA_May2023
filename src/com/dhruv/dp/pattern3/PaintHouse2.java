package com.dhruv.dp.pattern3;

import java.util.Arrays;

public class PaintHouse2 {
    public static void main(String[] args) {
        int n = 3 ;
        int k = 4 ;
        int[][] arr = new int[n][k] ;
        arr = new int[][]{
                {1,5,7,9},
                {2,3,4,6},
                {8,7,15,3}
        };
        int [][] dp = new int[n][k] ;
        for( int j = 0 ; j<k ; j++ ){
            dp[0][j] = arr[0][j] ;
        }
        for( int i = 1 ; i<n; i++ ){
            for ( int j = 0 ; j<k ; j++ ){
                int min = Integer.MAX_VALUE ;
                for( int l = 0 ; l<k ;l++ ){
                    if( l != j ){
                        min = Math.min(min,dp[i-1][l]);
                    }
                }
                dp[i][j] = arr[i][j] + min ;
            }
        }
        for( int[] row: dp){
            System.out.println(Arrays.toString(row));
        }
        int ans = Integer.MAX_VALUE ;
        for( int lrCols = 0 ; lrCols < k ;lrCols++ ){
            ans = Math.min(ans,dp[n-1][lrCols]);
        }
        System.out.println(ans);
    }
}
