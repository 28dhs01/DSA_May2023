package com.dhruv.dp.pattern4_lcs;

public class LongestCommonSubstring {
    public static void main(String[] args) {

    }
    int longestCommonSubstr(String S1, String S2, int n, int m){
        // code here
        int[][] dp = new int[n+1][m+1] ;
        for( int i = 1 ; i<dp.length ; i++) {
            for( int j = 1 ; j<dp[0].length ; j++ ){
                if( S1.charAt(i-1) == S2.charAt(j-1) ){
                    dp[i][j] = 1+dp[i-1][j-1] ;
                }else{
                    dp[i][j] = 0 ;
                }
            }
        }
        int max = 0 ;
        for( int i = 1 ; i<dp.length ; i++ ){
            for( int j = 1 ;j <dp[0].length ; j++ ){
                max = Math.max(dp[i][j],max);
            }
        }
        return max ;
    }
}
