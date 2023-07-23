package com.dhruv.dp.basics;

public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 5 ;
//        int paths = countPaths(n);
//        int paths = countPathsMemoization(n,new int[n+1]);
        int paths = countPathsUsingTabulation(n);
        System.out.println(paths);
    }
    static int countPaths( int n ){
//        base case
        if( n==0 ){
            return 1 ;
        }
        if( n<0 ){
            return 0 ;
        }
//        body
        System.out.println("hello"+n);
        int cp1 = countPaths(n-1);
        int cp2 = countPaths(n-2);
        int cp3 = countPaths(n-3);
        int pathsForCall = cp1+cp2+cp3 ;
        return pathsForCall ;

    }
    static int countPathsMemoization(int n,int []qb){
//        base case
        if( n == 0 ){
            return 1 ;
        }
        if( n<0 ){
            return 0 ;
        }
        if(qb[n] != 0){
            return qb[n] ;
        }
//        body
        System.out.println("hello " +n);
        int cp1 = countPathsMemoization(n-1,qb);
        int cp2 = countPathsMemoization(n-2,qb);
        int cp3 = countPathsMemoization(n-3,qb);
        int tpc = cp1+cp2+cp3 ;
        qb[n] = tpc ;
        return tpc ;
    }
    static int countPathsUsingTabulation(int n){
        int []dp = new int[n+1] ;
        dp[0] = 1 ;
        for( int i = 1 ;i<dp.length ; i++ ){
            if( i == 1 ){
                dp[i] = dp[i-1] ;
            }else if( i == 2 ){
                dp[i] = dp[i-1] + dp[i-2] ;
            }else{
                dp[i] = dp[i-1] + dp[i-2] +dp[i-3] ;
            }
        }
        return dp[n] ;
    }
}
