package com.dhruv.dp.gfg;

import java.util.Arrays;

public class MinJumps {
    public static void main(String[] args) {
        int[] ar = {1, 0, 3, 2, 6, 7 } ;
        int ans = minJumps(ar) ;
        System.out.println(ans);
    }
    static int minJumps(int[] arr){
        // your code here
        Integer[] dp = new Integer[arr.length] ;
        dp[arr.length-1] = 0 ;
        for( int i = arr.length-2 ; i>=0 ; i-- ){
            int jpsPos = arr[i] ;
            int cur = Integer.MAX_VALUE ;
            for( int k = 1 ; k<=jpsPos && i+k<arr.length ; k++ ){
                if( dp[i+k] != null ){
                    cur = Math.min(cur,dp[i+k]) ;
                }
            }
            if( cur != Integer.MAX_VALUE ){
                dp[i] = cur+1 ;
            }else{
                dp[i] = null ;
            }
        }
        System.out.println( Arrays.toString(dp) ) ;
        if( dp[0] == null ){
            return -1;
        }
        return dp[0] ;
    }
}
