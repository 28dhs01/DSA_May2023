package com.dhruv.dp.leetcode;

public class SubsequenceOrNot {
    public static void main(String[] args) {
        String s = "abc" ;
        String t = "ahcgdb" ;
        char [] s1 = s.toCharArray();
        char [] s2 = t.toCharArray();
        int i = 0 ;
        int j = 0 ;
        int ctr = 0 ;
        while( i<s1.length && j<s2.length ){
            if( s1[i] == s2[j] ){
                i++ ;
                j++ ;
                ctr++ ;
            }else{
                j++ ;
            }
        }
        System.out.println(ctr==s1.length);
    }
}
