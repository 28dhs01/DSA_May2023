package com.dhruv.recursion;

public class StoneGame {
    public static void main(String[] args) {
        int [] piles = {5,3,4,5} ;
        boolean res = stoneGame(piles) ;
        System.out.println(res);
    }
    public static boolean stoneGame(int[] piles) {
        return check(piles,0,piles.length-1,0,true) ;
    }
    static boolean check(int[]piles, int s, int e , int stn, boolean aturn ){
        if( s>e ){
            if( stn>0 ){
                return true ;
            }
            return false ;
        }
        if( aturn == true ){
            boolean lft = check(piles,s+1,e,stn+piles[s],false) ;
            boolean rgt = check(piles,s,e-1,stn+piles[e],false) ;
            return lft||rgt ;
        }else{
            boolean lft = check(piles,s+1,e,stn-piles[s],true);
            boolean rgt = check(piles,s,e-1,stn-piles[e],true) ;
            return lft||rgt ;
        }
    }
}
