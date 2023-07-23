package com.dhruv.dp.leetcode;

import java.sql.SQLOutput;

public class DecodeWays {
    public static void main(String[] args) {
        String s = "10" ;
        int ans = numDecodings(s) ;
        System.out.println(ans);
    }
    public static int numDecodings(String s) {
        int[]dp = new int[s.length()] ;
        if( s.charAt(0) == '0' ){
            return 0 ;
        }
        dp[0] = 1 ;
        char ft = s.charAt(0) ;
        char sd = s.charAt(1) ;
        String com =""+ft+sd ;
        if(Integer.parseInt(com) <=26 ){
            dp[1] = 2 ;
        }else if( com.charAt(com.length()-1) == '0'){
            dp[1] = 0 ;
        }else{
            dp[1] = 1 ;
        }
        for( int i = 2 ; i<dp.length ; i++ ){
            char fst = s.charAt(i-1) ;
            char scd = s.charAt(i) ;
            int prv = Integer.parseInt(""+fst) ;
            int cur = Integer.parseInt(""+scd) ;
            int comb = Integer.parseInt(""+fst+scd) ;
//            System.out.println(comb);
            if( prv == 0 && cur==0 ){
                dp[i] = 0 ;
            }else if (cur == 0 ){
                if( comb <=26 ){
                    dp[i] = dp[i-2] ;
                }
            }else if ( prv == 0 ){
                int val = Integer.parseInt(s.substring(i-2,i)) ;
                if( val <=26 ){
                    dp[i] = dp[i-1] ;
                }
            }else{
                if (comb <=26 ){
                    dp[i] = dp[i-1]+dp[i-2] ;
                }else{
                    dp[i] = dp[i-1] ;
                }
            }
//            System.out.println(dp[i]);
        }
        return dp[dp.length-1] ;
    }
}
