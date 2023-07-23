package com.dhruv.dp.basics;

import java.util.Arrays;
import java.util.Scanner;

public class ClimbingStairsWithMinMoves {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        System.out.println("enter the value of n");
        int n = sc.nextInt() ;
        int[] arr = new int[n] ;
        for (int i = 0; i < arr.length; i++) {
            System.out.println("enter the max num of steps from "+i+" th stair");
            arr[i] = sc.nextInt() ;
        }
//        System.out.println(Arrays.toString(arr));
//        1. storage and meaning
//        2. direction
//        3. travel and solve
        Integer [] dp = new Integer[n+1] ;
//        dp[i] signifies the min no. of moves from i to the dest
        dp[dp.length-1] = 0 ;
        for( int i = dp.length-2 ; i>=0 ; i-- ){
            int min = Integer.MAX_VALUE ;
            for( int j = 1 ; j<= arr[i] && i+j < dp.length ; j++ ){
                if( dp[i+j] != null ){
                    min = Math.min(dp[i+j],min);
                }
            }
            if( min != Integer.MAX_VALUE ){
                dp[i] = 1+ min ;
            }
        }
        System.out.println(Arrays.toString(dp));
    }
}
