package com.dhruv.dp.pattern5_mcm;

import java.util.Arrays;

public class PalindromePartitioningMemoization {
    public static void main(String[] args) {
        String s = "nitin" ;
        System.out.println(minCut(s));
    }
    public static int minCut(String s) {
        int n = s.length() ;
        int[][] memo = new int[n][n] ;
        for( int[] r: memo){
            Arrays.fill(r,-1);
        }
        return solve(s,0,s.length()-1,memo);
    }
    static int solve( String s, int i, int j ,int [][] memo){
        if (i>=j){
            return 0 ;
        }
        if( isPalindrome(s,i,j)){
            return 0 ;
        }
        if( memo[i][j] != -1 ){
            return memo[i][j] ;
        }
        int ans = Integer.MAX_VALUE ;
        for( int k = i ; k<=j-1 ; k++ ){
            int tempAns = solve(s,i,k,memo)+solve(s,k+1,j,memo)+1 ;
            ans = Math.min(ans,tempAns) ;
        }
        memo[i][j] = ans ;
        return ans ;
    }
    static boolean isPalindrome(String s, int i, int j){
        String f = s.substring(i,j+1);
        String snd = "" ;
        for( int k = j ; k>=i ; k-- ){
            char ch = s.charAt(k) ;
            snd+=ch ;
        }
        return f.equals(snd) ;
    }
}
