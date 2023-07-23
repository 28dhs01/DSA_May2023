package com.dhruv.binary_search;

public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = {312884470} ;
        int h = 312884469;
        int ans = minEatingSpeed(piles,h) ;

        System.out.println(ans);
    }
    public static int minEatingSpeed(int[] piles, int h) {
        int s = Integer.MAX_VALUE ;
        int e = 0 ;
        for( int i = 0 ; i<piles.length ; i++ ){
            s = Math.min(s,piles[i]);
            e = Math.max(e,piles[i]);
        }
        while( s < e ){
            int m = s+(e-s)/2 ;
            check(piles,h,m);
            if( check(piles,h,m) == true ){
                e = m ;
            }else{
                s = m+1 ;
            }
        }
        return s ;
    }
    static boolean check(int[]piles, int h, int speed){
        int hrs = 0 ;
        int i = 0 ;
        int[] myPiles = new int[piles.length] ;
        for( int j = 0 ; j<piles.length ;j++ ){
            myPiles[j] = piles[j] ;
        }
        while( i<piles.length ){
            int remBananas = myPiles[i] - speed ;
            if( remBananas <= 0 ){
                hrs++ ;
                i++ ;
            }else{
                myPiles[i] = remBananas ;
                hrs++ ;
            }
        }
//        System.out.println(hrs);
        return hrs<=h ;
    }
}
