package com.dhruv.dp.stocksPattern;

public class BuyAndSellStocks2 {
    public static void main(String[] args) {
        int n = 10 ;
        int[] prc = {11,6,7,19,4,1,6,18,4,9};
        int toPrf = 0 ;
        int bd = 0 ;
        int sd = 0 ;
        for( int i = 1 ; i<prc.length ; i++ ){
            if( prc[i] >= prc[i-1] ){
                sd ++ ;
            }else{
                toPrf += prc[sd] - prc[bd] ;
                bd = i ;
                sd = i ;
            }
        }
        toPrf += prc[sd] - prc[bd] ;
        System.out.println(toPrf);
    }
}
