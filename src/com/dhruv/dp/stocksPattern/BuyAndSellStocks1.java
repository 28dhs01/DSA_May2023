package com.dhruv.dp.stocksPattern;

public class BuyAndSellStocks1 {
    public static void main(String[] args) {
        int n = 9 ;
        int[] prc = {11,6,7,19,4,1,6,18,4};
        int bd = 0 ;
        int mxPrt = 0 ;
        int pist = 0 ;
        for( int sd = 1 ; sd<prc.length ; sd++ ){
            if( prc[sd] < prc[bd]  ){
                bd = sd ;
            }
            pist = prc[sd] - prc[bd] ;
            if( pist > mxPrt ){
                mxPrt = pist ;
            }
        }
        System.out.println(mxPrt);
    }
}
