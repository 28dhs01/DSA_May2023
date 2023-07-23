package com.dhruv.dp.rem;

import java.util.Arrays;
import java.util.Scanner;

public class Tiling2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt() ;
        int m = scn.nextInt() ;
        int [] dp = new int[n+1];
        for( int i = 1 ; i<dp.length ; i++ ){
            if( i<m ){
                dp[i] = 1 ;
            }else if( i == m ){
                dp[i] = 2 ;
            }else{
                dp[i] = dp[i-1] + dp[i-m] ;
            }
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(dp[dp.length-1]);


        System.out.println(usingRec(4));
    }
    static int usingRec( int n ){
        if( n<=2 ){
            return n ;
        }
        return usingRec(n-1)+usingRec(n-2) ;
    }
}
