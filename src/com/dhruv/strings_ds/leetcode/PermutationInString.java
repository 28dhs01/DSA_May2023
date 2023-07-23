package com.dhruv.strings_ds.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationInString {
    public static void main(String[] args) {
        String s1 = "adc";
        String s2 = "dcda" ;
        boolean res = checkInclusion(s1,s2) ;
        System.out.println(res);
    }
    public static boolean checkInclusion(String s1, String s2) {
        s1 = sort(s1) ;
        int len = s1.length() ;
        for( int i = 0 ; i<=s2.length()-len ; i++ ){
            String per = s2.substring(i,len+i) ;
            per = sort(per) ;
            if(per.equals(s1)){
                return true ;
            }
        }
        return false ;
    }
    static String sort(String s){
        char[] charArr = s.toCharArray() ;
        Arrays.sort(charArr) ;
        return new String(charArr) ;
    }
}
