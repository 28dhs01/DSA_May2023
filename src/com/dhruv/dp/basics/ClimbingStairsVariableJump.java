package com.dhruv.dp.basics;

import java.util.Arrays;
import java.util.Scanner;

public class ClimbingStairsVariableJump {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("enter the value of n");
//        int n = sc.nextInt();
//        int [] arr = new int[n] ;
//        for( int i = 0 ; i<n ; i++ ){
//            System.out.println("enter the max amount of jumps by "+i+" the idx");
//            arr[i] = sc.nextInt();
//        }
////        System.out.println(Arrays.toString(arr));
//        int [] dp = new int[n+1] ;
//        dp[dp.length-1] = 1 ;
//        for (int i = dp.length-2; i >= 0 ; i--) {
//            for( int j = 1 ; j<= arr[i] && i+j < dp.length ; j++ ){
//                dp[i] += dp[i+j];
//            }
//        }
//        System.out.println(Arrays.toString(dp));
//        System.out.println(dp[0]);
//
//
//        int ans = usingRec(0,n,arr);
//        System.out.println(ans);
//        int ans2 = usingRecMemo(0,n,arr,new int[n+1]);
//        System.out.println(ans2);

        int[] ar = {2,3,0,2,2,3} ;
        int ans = usingTab(ar) ;
        System.out.println(ans);
    }
    static int usingRec(int src, int dest, int []arr ){
//        base case
        if( src == dest ){
            return 1 ;
        }
        if( src>dest ){
            return 0 ;
        }
//        body
        int callAns = 0 ;
        System.out.println("hello "+ src);
        for( int i = 1 ; i<=arr[src] ; i++ ){
            callAns += usingRec(src+i,dest,arr);
        }
        return callAns ;
    }
    static int usingRecMemo(int src, int dest, int []arr ,int []qb ){
//        base case
        if( src == dest ){
            return 1 ;
        }
        if( src>dest ){
            return 0 ;
        }
        if( qb[src] != 0 ){
            return qb[src] ;
        }
//        body
        int callAns = 0 ;
        System.out.println("hello "+ src);
        for( int i = 1 ; i<=arr[src] ; i++ ){
            callAns += usingRecMemo(src+i,dest,arr,qb);
        }
        qb[src] = callAns ;
        return qb[src] ;
    }
    static int usingTab(int[] arr){
        int n = arr.length ;
        int[] dp = new int[n+1] ;
        dp[dp.length-1] = 1 ;
        for( int i = dp.length-2 ; i>=0  ; i-- ){
            int sum = 0  ;
            for( int j = 1 ; j<=arr[i] && i+j<dp.length ; j++ ){
                sum += dp[i+j] ;
            }
            dp[i] = sum ;
        }
        return dp[0] ;
    }
}
