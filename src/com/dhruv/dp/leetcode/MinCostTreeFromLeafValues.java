package com.dhruv.dp.leetcode;

import java.util.Arrays;

public class MinCostTreeFromLeafValues {
    public static void main(String[] args) {
        int[] ar = {6,2,4} ;
        int res = mctFromLeafValues(ar) ;
        System.out.println(res);
    }
    public static int mctFromLeafValues(int[] arr) {
        int lastIdx = arr.length -1 ;
        int ans = Integer.MAX_VALUE ;
        int [][] memo = new int[arr.length][arr.length] ;
        for( int [] ar: memo ){
            Arrays.fill(ar,-1) ;
        }

        for( int i = 0 ; i<lastIdx ; i++ ){
            System.out.println(i) ;
            int ptAns = findMinSum(arr,0,lastIdx,memo) ;
            System.out.println(ptAns) ;
            ans = Math.min(ptAns,ans) ;
            System.out.println() ;
        }
        return ans ;
    }
    static int findMinSum(int[] arr, int s , int e, int[][] memo){
        if( s >= e ){
            return 0 ;
        }
        if( memo[s][e] != -1 ){
            return memo[s][e] ;
        }
        int curAns = Integer.MAX_VALUE ;
        for( int i = s ; i<e ; i++ ){
            curAns = Math.min( findMax(arr,s,i) * findMax(arr,i+1,e) + findMinSum(arr,s,i,memo) + findMinSum(arr,i+1,e,memo) ,curAns);
        }
        // System.out.println(curAns) ;
        memo[s][e] = curAns ;
        return curAns ;
    }
    static int findMax(int[]ar, int s, int e ){
        int mx = ar[s] ;
        for( int i = s + 1 ; i<=e ; i++ ){
            mx = Math.max(mx,ar[i]) ;
        }
        return mx ;
    }
}
