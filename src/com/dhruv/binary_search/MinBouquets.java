package com.dhruv.binary_search;

public class MinBouquets {
    public static void main(String[] args) {
        int[] bloomDay = {1,10,3,10,2};
        int m = 3 ;
        int k = 1 ;
        int ans = minDays(bloomDay,m,k);
        System.out.println(ans);
    }
    public static int minDays(int[] bloomDay, int m, int k) {
        if( m*k > bloomDay.length ){
            return -1 ;
        }
        int s = 1 ;
        int e = 0 ;
        for( int i = 0 ; i<bloomDay.length ; i++ ){
            e = Math.max(e,bloomDay[i]);
        }
        int ans = -1 ;
        while( s<=e ){
            int mid = s+(e-s)/2 ;
            if( isPossible(bloomDay,m,k,mid) ){
                ans = mid ;
                e = mid-1 ;
            }else{
                s = mid+1 ;
            }
        }
        return ans ;
    }
    static boolean isPossible( int[] bloomDay, int m , int k , int days ){
        int bqCnt = 0 ;
        int pair = 0 ;
        for( int i = 0 ; i<bloomDay.length ; i++ ){
            if( bloomDay[i] <= days ){
                pair++ ;
                if( pair == k ){
                    bqCnt++ ;
                    pair = 0 ;
                }
            }else{
                pair = 0 ;
            }
        }
        return bqCnt >= m;
    }
}
