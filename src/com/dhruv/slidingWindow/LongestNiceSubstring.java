package com.dhruv.slidingWindow;

import java.util.ArrayList;
import java.util.List;

public class LongestNiceSubstring {
    public static void main(String[] args) {
        String s = "YazaAay" ;
        String ans = longestNiceSubstring(s) ;
        System.out.println(ans);
    }
    public static String longestNiceSubstring(String s) {
        List<String> list = new ArrayList<>();
        for( int i = 0 ;i<s.length() ;i++ ){
            StringBuilder sb = new StringBuilder();
            for( int j = i ; j<s.length() ; j++ ){
                char ch = s.charAt(j) ;
                sb.append(ch) ;
                if( isNice(sb.toString()) ){
                    list.add(sb.toString());
                }
            }
        }
        String lgst = "" ;
        for( String str: list ){
            if( str.length() > lgst.length() ){
                lgst = str ;
            }
//            System.out.println(str);
        }

        return lgst ;
    }
    static boolean isNice(String str){
        for( int i = 0 ; i<str.length() ; i++ ){
            char ch = str.charAt(i) ;
            char f = Character.toUpperCase(ch) ;
            char s = Character.toLowerCase(ch) ;
            if( str.contains(f+"") && str.contains(s+"") ){
                continue;
            }else {
                return false ;
            }
        }
        return true ;
    }
}
