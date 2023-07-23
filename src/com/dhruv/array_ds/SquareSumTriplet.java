package com.dhruv.array_ds;

public class SquareSumTriplet {
    public static void main(String[] args) {
        int n = 5 ;
        int ans = countTriples(n) ;
        System.out.println(ans);
    }
    public static int countTriples(int n) {
        int cnt = 0 ;
        for( int a = 1 ; a<=n-2 ; a++ ){
            for( int b = a+1 ; b<=n-1 ; b++ ){
                for( int c = b+1 ; c<=n ; c++ ){
                    if( (a*a) + (b*b) == c*c ){
                        cnt += 2 ;
                    }
                }
            }
        }
        return  cnt ;
    }
}
