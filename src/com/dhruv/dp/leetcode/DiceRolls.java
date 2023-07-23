package com.dhruv.dp.leetcode;

import java.util.Arrays;

public class DiceRolls {
    public static void main(String[] args) {
        int n = 2 ;
        int k = 6 ;
        int target = 7 ;
        int ans = numRollsToTarget(n,k,target) ;
        System.out.println(ans);
    }
    static int mod = 1000000007 ;
    public static int numRollsToTarget(int n, int k, int target) {
        int[][] memo = new int[n+1][target+1] ;
        for( int []ar: memo ){
            Arrays.fill(ar,-1) ;
        }
        helper(n,k,target,target,memo) ;
        return memo[n][target] ;
    }
    static int helper(int n, int k , int target, int stn, int [][] memo ){
        // System.out.println(stn) ;
        if( stn == 0 && n == 0 ){
            return 1;
        }
        if( n==0 || stn<0 ){
            return 0 ;
        }
        if( memo[n][stn] != -1 ){
            return memo[n][stn] ;
        }
        int cnt = 0 ;
        for( int i = 1 ; i<=k ; i++ ){
            cnt = ( cnt+helper(n-1,k,target,stn-i,memo) ) % mod ;
        }
        memo[n][stn] = cnt ;
        return memo[n][stn] ;
    }
}
