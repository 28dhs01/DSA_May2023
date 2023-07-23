package com.dhruv.dp.pattern4_lcs;

public class LCS_recursive {
    public static void main(String[] args) {
        String text1 = "abcde", text2 = "ace" ;
        System.out.println(longestCommonSubsequence(text1,text2));
    }
    public static int longestCommonSubsequence(String text1, String text2) {
        return helper(text1,text2,text1.length(),text2.length() );
    }
    static int helper(String s1, String s2 , int m, int n ){
        if( m == 0 || n==0 ){
            return 0 ;
        }
        if( s1.charAt(m-1) == s2.charAt(n-1) ){
            return 1+helper(s1,s2,m-1,n-1);
        }else{
            int f = helper(s1,s2,m,n-1);
            int s = helper(s1,s2,m-1,n);
            return Math.max(f,s);
        }
    }
}
