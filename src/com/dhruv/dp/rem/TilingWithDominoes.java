package com.dhruv.dp.rem;

import java.util.Arrays;
import java.util.Scanner;

public class TilingWithDominoes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        dp[1] = 1 ;
        dp[2] = 2 ;
        for( int i = 3 ; i<dp.length ; i++ ){
            dp[i] = dp[i-1] + dp[i-2] ;
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(dp[dp.length-1]);
    }
}
