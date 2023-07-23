package com.dhruv.slidingWindow;

public class GoodSubstrings {
    public static void main(String[] args) {
        int ans=  countGoodSubstrings("aababcabc");
        System.out.println(ans);
    }
    public static int countGoodSubstrings(String s) {
        int cnt = 0 ;
        for( int i = 0 ; i<s.length()-2 ; i++ ){
            char fst = s.charAt(i) ;
            char snd = s.charAt(i+1);
            char td = s.charAt(i+2);
            if( fst != snd && snd!= td && td!= fst ){
                cnt++ ;
            }
        }
        return cnt ;
    }
}
