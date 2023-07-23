package com.dhruv.algorithm;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "babad" ;
        String res = longestPalindrome(s) ;
        System.out.println(res);
    }
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1)
            return "";

        int start = 0 ;
        int end = 0 ;
        for( int i = 0 ; i<s.length() ; i++ ){
            int l1 = expandFromCenter(s,i,i) ;
            int l2 = expandFromCenter(s,i,i+1) ;
            int l = Math.max(l1,l2) ;
            if( l>end-start ){
                start = i - (l-1)/2 ;
                end = i+l/2 ;
            }
        }
        return s.substring(start,end+1) ;
    }
    static int expandFromCenter(String s , int lft, int rgt ){
        while( lft >= 0 && rgt < s.length() && s.charAt(lft) == s.charAt(rgt) ){
            lft-- ;
            rgt++ ;
        }
        return rgt-lft-1 ;
    }
}
