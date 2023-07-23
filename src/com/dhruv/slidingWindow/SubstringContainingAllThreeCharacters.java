package com.dhruv.slidingWindow;

public class SubstringContainingAllThreeCharacters {
    public static void main(String[] args) {
        String s = "abcabc" ;
        int ans = numberOfSubstrings(s) ;
        System.out.println(ans);
    }
    public static int numberOfSubstrings(String s) {
        char [] ar = s.toCharArray() ;
        int cnt = 0 ;
        int st = 0 ;
        int e = 0 ;
        int[] allPresent = new int[3] ;
        int res = 0 ;
        while( e<s.length() ){
            char ch = ar[e] ;
            allPresent[ch-'a'] ++ ;
            while( allPresent[0] > 0 && allPresent[1]>0 && allPresent[2]>0 ){
                cnt++ ;
                char chPSt = ar[st] ;
                allPresent[chPSt-'a']--;
                st++ ;
            }
            res += cnt ;
            e++ ;
        }
        return res ;
    }
}
