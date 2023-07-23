package com.dhruv.strings_ds.leetcode;

public class ReplaceWithChar {
    public static void main(String[] args) {
        int s = 'a' + 2 ;
        System.out.println(s);
        char c = (char)(s) ;
        System.out.println(c);
        System.out.println(replaceDigits("a1c1e1"));
    }
    public static String replaceDigits(String s) {
        String res = "" ;
        for( int i = 0 ; i<s.length() ;i++ ){
            char ch = s.charAt(i) ;
            if( !( ch>='a' && ch<='z' ) ){
                char prv = s.charAt(i-1) ;
                int val = Integer.parseInt(""+ch);
                System.out.println(val);
                val = prv+val ;
                char nwc = (char)(val) ;
                res += nwc ;
            }else{
                res+=ch ;
            }
        }
        return res;
    }
}
