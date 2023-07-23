package com.dhruv.binary_search;

public class ShipPackages {
    public static void main(String[] args) {
        int[] weights = {1,2,3,1,1};
        int days = 4 ;
        int ans = shipWithinDays(weights,days);
        System.out.println(ans);
    }
    public static int shipWithinDays(int[] weights, int days) {
        int s = 0 ;
        int e = 0 ;
        for( int i = 0 ; i<weights.length ; i++ ){
            s = Math.max(s,weights[i]);
            e += weights[i];
        }
        while( s<e ){
            int m = s+(e-s)/2 ;
            // System.out.print(m+" - ") ;
            if(!calculate(weights,days,m)){
                s = m+1 ;
            }else{
                e = m ;
            }
        }
        return s ;
    }
    static boolean calculate(int[]weights, int days, int lmt ){
        int clcDays = 1 ;
        int sum = 0 ;
        for( int i = 0 ; i<weights.length ; i++ ){
            sum += weights[i] ;
            if( sum > lmt ){
                clcDays++ ;
                sum = weights[i] ;
            }
        }
        // System.out.println(clcDays);
        return clcDays<=days ;
    }
}
