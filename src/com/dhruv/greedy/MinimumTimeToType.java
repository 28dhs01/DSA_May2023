package com.dhruv.greedy;

public class MinimumTimeToType {
    public static void main(String[] args) {
        String word = "zjpc" ;
//        System.out.println('c'-'a');
//        int val = 'a'-'v' ;
//        System.out.println(val);
//        System.out.println(26+val);
//        char c = 'a'+2 ;
//        System.out.println(c);
//        System.out.println('a'-'v');
        int mnTime = minTimeToType(word) ;
        System.out.println(mnTime);
    }
    public static int minTimeToType(String word) {
        int tm = 0 ;
        char cur = 'a' ;
        for( int i = 0 ; i<word.length() ; i++ ){
            char ch = word.charAt(i) ;
            int mn  ;
            if( ch<cur ){
                int f = Math.abs(ch-cur) ;
                int s = 26-(cur-ch) ;
                mn = Math.min(f,s) ;
            }else{
                int f = ch-cur;
                int s = 26+cur-ch ;
                mn = Math.min(f,s) ;
            }

            tm += mn ;
            cur = ch;
            tm++ ;
        }
        return tm ;
    }
}
