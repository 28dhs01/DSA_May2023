package com.dhruv.dp.pattern2;

import java.util.Arrays;
import java.util.Scanner;

public class TargetSumSubset {
    public static void main(String[] args) {
        int [] nums = {4,2,7,1,3} ;
        int tar = 10 ;
        boolean [][] dp = new boolean[nums.length+1][tar+1] ;
        for( int i = 0 ; i<dp.length ; i++ ){
            for( int j = 0 ; j<dp[i].length ; j++ ){
                if( i == 0  && j ==0 ){
                    dp[i][j] = true ;
                } else if (i==0) {
                    dp[i][j] = false ;
                } else if( j==0 ){
                    dp[i][j] = true ;
                }else {
//                    2 choices -> reject or select
//                    1. reject
                    if (dp[i-1][j] == true){
                        dp[i][j] = true ;
                    }
//                    2. select
                    else{
                        int remainingSum = j - nums[i-1] ;
                        if( remainingSum >= 0 ){
                            dp[i][j] = dp[i-1][remainingSum];
                        }
                    }
                }
            }
        }
        for ( boolean[] row : dp){
            System.out.println(Arrays.toString(row));
        }
    }
}
