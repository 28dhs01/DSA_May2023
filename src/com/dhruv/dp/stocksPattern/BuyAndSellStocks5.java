package com.dhruv.dp.stocksPattern;

import java.util.Arrays;

public class BuyAndSellStocks5 {
    public static void main(String[] args) {
        int n = 8 ;
        int [] prc = {5,10,6,2,8,15,7,1};
        int [] dpl = new int[prc.length];
        dpl[0] = 0 ;
        int bdtb = 0;
        int mxpttl = 0 ;
        for( int i = 1 ; i< dpl.length ; i++ ){
            if( prc[i]<prc[bdtb] ){
                bdtb = i ;
            }
            int tpr = prc[i] - prc[bdtb] ;
            if( tpr > mxpttl ){
                mxpttl = tpr ;
            }
            dpl[i] = mxpttl ;
        }
        System.out.println(Arrays.toString(dpl));

        int[] dpr = new int[prc.length];
        int bdts = dpr.length-1 ;
        int mxpttr = 0 ;
        dpr[dpr.length-1] = 0 ;
        for( int i = dpr.length-2 ; i>=0 ; i-- ){
            if( prc[i] > prc[bdts] ){
                bdts = i ;
            }
            int tpr = prc[bdts] - prc[i] ;
            if( tpr > mxpttr ){
                mxpttr = tpr ;
            }
            dpr[i] = mxpttr;
        }
        System.out.println(Arrays.toString(dpr));
        int ans = Integer.MIN_VALUE ;
        for ( int i = 0 ; i< dpl.length ; i++ ){
            int cAns = dpl[i] + dpr[i] ;
            if( cAns > ans ){
                ans = cAns ;
            }
        }
        System.out.println(ans);
    }
}
