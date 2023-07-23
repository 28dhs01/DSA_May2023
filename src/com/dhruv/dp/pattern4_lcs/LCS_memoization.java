package com.dhruv.dp.pattern4_lcs;

import java.util.Arrays;

public class LCS_memoization {
    public static void main(String[] args) {
        String text1 = "abcde", text2 = "aec" ;
        System.out.println(longestCommonSubsequence(text1,text2));
    }
    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length() ;
        int n = text2.length() ;
        int[][] dp = new int[m+1][n+1];
        for( int i = 0 ; i<dp.length ; i++ ){
            for( int j = 0 ; j<dp[0].length ; j++ ){
                dp[i][j] = -1 ;
            }
        }
        return helper(text1,text2,m,n,dp);
    }
    static int helper(String s1, String s2 , int m, int n, int[][] dp ){
        if( m == 0 || n==0 ){
            dp[m][n] = 0 ;
            return 0 ;
        }
        if( dp[m][n] != -1 ){
            return dp[m][n] ;
        }
        if( s1.charAt(m-1) == s2.charAt(n-1) ){
            dp[m][n] = 1+helper(s1,s2,m-1,n-1,dp) ;
            return dp[m][n] ;
        }else{
            int f = helper(s1,s2,m,n-1,dp);
            int s = helper(s1,s2,m-1,n,dp);
            dp[m][n] = Math.max(f,s) ;
            return dp[m][n];
        }
    }
}
