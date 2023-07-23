package com.dhruv.algorithm;

public class GCD {
    public static void main(String[] args) {
        int a = 27 ;
        int b = 15 ;
//        int res = findGCD(a,b) ;
        int ans = findGCD2(a,b) ;
//        System.out.println(res);
        System.out.println(ans);
    }
    static int findGCD(int a, int b){
        if( a%b == 0 ){
            return b ;
        }
        return findGCD(b,a%b) ;
    }
    static int findGCD2(int a, int b){
        if( b == 0 ){
            return a ;
        }
        if ( a == 0 ){
            return b ;
        }
        int val ;
        if( a>b ){
            val = a-b ;
            return findGCD2(val,b) ;

        }else{
            val = b-a ;
            return findGCD2(val,a) ;
        }
    }
}
