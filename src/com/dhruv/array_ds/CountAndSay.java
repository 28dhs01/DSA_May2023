package com.dhruv.array_ds;

import java.util.Arrays;
import java.util.Stack;

public class CountAndSay {
    public static void main(String[] args) {
        int n = 4 ;
        String res = countAndSay(n) ;
        System.out.println(res);
    }
    public static String countAndSay(int n) {
        String[] ar = new String[n+1] ;
        ar[0] = "0" ;
        ar[1] = "1" ;
        for( int i = 2 ; i<ar.length ; i++ ){
            ar[i] = calculate(ar[i-1]) ;
        }
        return ar[n] ;
    }
    static String calculate(String s){
        char [] ar = s.toCharArray() ;
        StringBuilder res = new StringBuilder();
        int cnt = 1 ;
        for(int ptr = 0 ; ptr<ar.length-1 ; ptr++ ){
            if( ar[ptr] == ar[ptr+1] ){
                cnt++ ;
            }else {
                res.append(cnt);
                res.append(ar[ptr]);
                cnt = 1 ;
            }
        }
        res.append(cnt);
        res.append(ar[ar.length-1]);
        return res.toString();
    }
}
