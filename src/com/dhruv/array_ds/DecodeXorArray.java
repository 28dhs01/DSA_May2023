package com.dhruv.array_ds;

public class DecodeXorArray {
    public static void main(String[] args) {
        int x = 6 ;
        int a = 4 ;
        int b = x^a ;
        System.out.println(b);
    }
    public static int[] decode(int[] encoded, int first) {
        int []ans = new int[encoded.length+1] ;
        ans[0] = first ;
        for( int i = 1 ; i<ans.length ; i++ ){
            ans[i] = encoded[i-1]^ans[i-1] ;
        }
        return ans ;
    }
}
