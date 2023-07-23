package com.dhruv.dp.rem;

import java.util.Arrays;

public class PartitionsIntoSubsets {
    public static void main(String[] args) {
        int n = 5 ;
        int k = 3 ;
        int[][] dp = new int[k+1][n+1] ;
        for( int teams = 1 ; teams< dp.length ; teams++ ){
            for( int people = 1 ; people<dp[teams].length ; people++ ){
                if( teams == 1 ){
                    dp[teams][people] = 1 ;
                }
                else if( people<teams ){
                    dp[teams][people] = 0 ;
                } else if (people==teams) {
                    dp[teams][people] = 1 ;
                } else{
                    dp[teams][people] = dp[teams][people-1]*teams + dp[teams-1][people-1];
                }
            }
        }
        for( int[] row : dp){
            System.out.println(Arrays.toString(row));
        }
        System.out.println(dp[k][n]);

    }
}
