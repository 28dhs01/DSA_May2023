package com.dhruv.hashmap_ds.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
    public static void main(String[] args) {
        int ans = lengthOfLongestSubstring("aab");
        System.out.println(ans);
    }
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>() ;
        int mxLn = 0 ;
        int i = 0 ;
        int j = 0 ;
        while( i<s.length()){
            char key = s.charAt(i) ;
            if( set.contains(key)){
                set.remove(s.charAt(j));
                j++ ;
            }else{
                set.add(key);
                mxLn = Math.max(mxLn,set.size());
                i++ ;
            }
        }
        return mxLn ;
    }
}
