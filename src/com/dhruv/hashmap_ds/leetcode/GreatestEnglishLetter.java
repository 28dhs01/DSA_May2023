package com.dhruv.hashmap_ds.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GreatestEnglishLetter {
    public static void main(String[] args) {
        String s = "arRAzFif" ;
        String res = greatestLetter(s) ;
        System.out.println(res);
    }
    public static String greatestLetter(String s) {
        Set<String> set = new TreeSet<>();
        for( int i = 0 ; i<s.length() ; i++ ){
            char ch = s.charAt(i) ;
            String f = Character.toUpperCase(ch)+"" ;
            String scd = Character.toLowerCase(ch)+"" ;
            if( s.contains(f) && s.contains(scd) ){
                set.add(f) ;
            }
        }
        System.out.println(set);
        String[] ar = new String[set.size()];
        int i = 0 ;
        for( String e: set ){
            ar[i] = e ;
            i++ ;
        }
        System.out.println(Arrays.toString(ar));
        return  ar[ar.length-1];
    }
}
