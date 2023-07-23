package com.dhruv.dp.pattern5_mcm;

import java.util.Arrays;

public class EggDroppingMemoization {
    public static void main(String[] args) {
        int ans = superEggDrop(3,5) ;
        System.out.println(ans);
    }
    public static int superEggDrop(int k, int n) {
        int[][]memo = new int[k+1][n+1] ;
        for(int[]ar: memo){
            Arrays.fill(ar,-1);
        }
        return solve(k,n,memo) ;
    }
    static int solve(int e, int f,int[][]memo){
//        bc
        if( e==1 || f==1 || f==0){
            return f ;
        }
        if( memo[e][f] != -1 ){
            return memo[e][f] ;
        }
//        k loop
        int mn = Integer.MAX_VALUE ;
        for ( int k = 1 ; k<=f ; k++ ){
            int tmpAns =1+ Math.max ( solve(e-1,k-1,memo),solve(e,f-k,memo) )  ;
            mn = Math.min(mn,tmpAns) ;
        }
        memo[e][f] = mn ;
        return mn ;
    }
}
