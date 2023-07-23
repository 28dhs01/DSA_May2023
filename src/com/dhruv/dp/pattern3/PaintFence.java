package com.dhruv.dp.pattern3;

public class PaintFence {
    public static void main(String[] args) {
        int n = 5 ;
        int k = 3 ;
        int same = k ;
        int different = k*(k-1);
        int total = same + different ;
        for( int i = 3 ; i<=n ; i++ ){
            same = different ;
            different = total * (k-1) ;
            total = same + different ;
        }
        System.out.println(total);
    }
}
