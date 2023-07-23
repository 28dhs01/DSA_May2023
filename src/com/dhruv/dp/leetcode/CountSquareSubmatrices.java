package com.dhruv.dp.leetcode;

import java.util.Arrays;

public class CountSquareSubmatrices {
    public static void main(String[] args) {
        int[][] matrix = {
                {0,1,1,1},
                {1,1,1,1},
                {0,1,1,1}
        };
        int[][] dp = new int[matrix.length][matrix[0].length];
        for( int r = 0 ; r<dp.length ; r++ ){
            for( int c = 0 ; c<dp[r].length ; c++ ){
                if( matrix[r][c] == 0 ){
                    dp[r][c] = 0 ;
                }else{
                    int cnt = 1 ;
                    if( r>0 && c>0 ){
                        int f = dp[r-1][c] ;
                        int s = dp[r-1][c-1] ;
                        int t = dp[r][c-1] ;
                        cnt += Math.min(f,Math.min(s,t));
                    }
                    dp[r][c] = cnt ;
                }
            }
        }
        for( int[] arr: dp ){
            System.out.println(Arrays.toString(arr));
        }
    }
}
