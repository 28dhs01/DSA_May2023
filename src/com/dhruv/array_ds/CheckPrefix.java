package com.dhruv.array_ds;

public class CheckPrefix {
    public static void main(String[] args) {
        String sentence = "i love eating burger" ; String searchWord = "burger" ;
        int res = isPrefixOfWord(sentence,searchWord) ;
        System.out.println(res);
    }
    public static int isPrefixOfWord(String sentence, String searchWord) {
        int ans = -1 ;
        StringBuilder sb = new StringBuilder();
        int idx = 1 ;
        for( int i = 0 ; i<sentence.length() ; i++ ){
            char ch = sentence.charAt(i) ;
            if( ch == ' ' ){
                String word = sb.toString() ;
                System.out.println(word);
                if( word.startsWith(searchWord) ){
                    return idx ;
                }
                idx++ ;
                sb = new StringBuilder() ;
            }else{
                sb.append(ch) ;
            }
        }
        String word = sb.toString();
        if( word.startsWith(searchWord) ){
            return idx ;
        }
        return ans ;
    }
}
