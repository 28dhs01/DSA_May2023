package com.dhruv.array_ds;

public class DivideTwoIntegers {
    public static void main(String[] args) {
        int ans = divide(120,3) ;
        System.out.println(ans);
    }
    public static int divide(int dividend, int divisor) {
        if( dividend == Integer.MIN_VALUE && divisor == -1 ){
            return Integer.MAX_VALUE ;
        }
        if( dividend== Integer.MIN_VALUE && divisor == 1 ){
            return Integer.MIN_VALUE ;
        }
        int res = 0 ;
        int dd = Math.abs(dividend) ;
        int dv = Math.abs(divisor) ;
        while( dv<=dd ){
            int cnt = 1 ;
            int sum = dv ;
            while( sum<=dd ){
                sum = sum<<1 ;
                cnt = cnt<<1 ;
            }
            cnt = cnt>>1 ;
            sum = sum>>1 ;
            res += cnt ;
            dd = dd-sum ;
        }
        if( ( dividend >= 0 && divisor>0 ) || ( dividend<0 && divisor<0 )){
            return res ;
        }
        return -res ;
    }
}
