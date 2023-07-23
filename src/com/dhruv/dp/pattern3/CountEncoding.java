package com.dhruv.dp.pattern3;

import java.util.Arrays;
import java.util.Scanner;

public class CountEncoding {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        String str = sc.next();
        int[] dp = new int[str.length()] ;
        dp[0] = 1 ;
        for( int i = 1 ; i<dp.length ; i++ ){
            if( str.charAt(i-1) == '0' && str.charAt(i) == '0' ){
                dp[i] = 0 ;
            }else if( str.charAt(i-1) == '0' && str.charAt(i) != '0' ){
                dp[i] = dp[i-1];
            }else if( str.charAt(i-1) != '0' && str.charAt(i) == '0' ) {
                if( str.charAt(i-1) <= '2'){
                    if( i - 2 >=0 ){
                        dp[i] = dp[i-2] ;
                    }else{
                        dp[i] = 1 ;
                    }
                }else{
                    dp[i] = 0 ;
                }
            }else{
                String l2 = str.substring(i-1,i+1) ;
                int inl2 = Integer.parseInt(l2) ;
                if( inl2 <= 26 ){
                    dp[i] = dp[i-1] ;
                    if( i - 2 >= 0 ){
                        dp[i]+= dp[i-2] ;
                    }else{
                        dp[i] += 1 ;
                    }
                }else{
                    dp[i] = dp[i-1] ;
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(dp[dp.length-1]);
    }
}
