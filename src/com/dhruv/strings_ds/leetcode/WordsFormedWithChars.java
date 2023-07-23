package com.dhruv.strings_ds.leetcode;

public class WordsFormedWithChars {
    public static void main(String[] args) {
        String[] words = {"cat","bt","hat","tree"};
        String chars = "atach" ;
        int ans = countCharacters(words,chars) ;
        System.out.println(ans);

    }
    public static int countCharacters(String[] words, String chars) {
        char[] arr = chars.toCharArray() ;
        int res = 0 ;
        for( String word: words ){
            boolean [] used = new boolean[chars.length()] ;
            boolean flag = true ;
            for ( int i = 0 ; i<word.length() ; i++ ){
                char ch = word.charAt(i) ;
                boolean present = isPresent(ch,arr,used) ;
                if( present == false ){
                    flag = false ;
                    break;
                }
            }
            if( flag == true ){
                System.out.println(word);
                res += word.length() ;
            }
        }
        return res ;
    }
    static boolean isPresent(char ch,char[] arr, boolean[] used){
        for( int i = 0 ; i<arr.length ; i++ ){
            if( arr[i] == ch && used[i] == false ){
                used[i] = true ;
                return true ;
            }
        }
        return false;
    }
}
