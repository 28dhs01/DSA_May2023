package com.dhruv.dp.leetcode;

public class SubstringDifferBy1 {
    public static void main(String[] args) {
        String s = "ab" ;
        String t = "bb" ;
        int ans = 0 ;
        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray() ;
        for( int i = 0 ; i<s1.length ; i++ ){
            for( int j = 0 ;  j<s2.length  ; j++ ){
                int x = i ;
                int y = j ;
                int difCnt = 0 ;
                while( x<s1.length && y<s2.length ){
                    if( s1[x] != s2[y] ){
                        difCnt ++ ;
                    }
                    if( difCnt == 1 ){
                        ans++ ;
                    }
                    if( difCnt > 1 ){
                        break ;
                    }
                    x++ ;
                    y++;
                }
            }
        }
        System.out.println(ans);
    }
}
