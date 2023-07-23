package com.dhruv.dp.pattern3;

public class CountABCSubsequences {
    public static void main(String[] args) {
        String str = "abcabc";
        int a = 0 ;
        int ab = 0 ;
        int abc = 0 ;
        for( int i = 0 ; i<str.length() ; i++ ){
            char ch = str.charAt(i) ;
            if( ch == 'a' ){
                a = a + a + 1 ;
            }else if( ch == 'b') {
                ab = ab + ab + a ;
            }else if( ch == 'c' ){
                abc = abc + abc + ab ;
            }
        }
        System.out.println(abc);
    }
}
