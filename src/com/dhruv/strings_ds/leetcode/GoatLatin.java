package com.dhruv.strings_ds.leetcode;

public class GoatLatin {
    public static void main(String[] args) {
        String sentence = "I speak Goat Latin" ;
        String res = toGoatLatin(sentence) ;
        System.out.println(res);
    }
    public static String toGoatLatin(String sentence) {
        int i = 0 ;
        int wordCnt = 1 ;
        StringBuilder sb = new StringBuilder() ;
        while( i<sentence.length() ){
            char ch = sentence.charAt(i) ;
            if( ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
                    || ch =='A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' ){
                System.out.println(ch) ;
                sb.append(ch) ;
                i++ ;
                while( i<sentence.length() && sentence.charAt(i) != ' ' ){
                    sb.append(sentence.charAt(i) );
                    i++ ;
                }
            }else{
                i++ ;
                while( i<sentence.length() && sentence.charAt(i) != ' ' ){
                    sb.append(sentence.charAt(i) );
                    i++ ;
                }
                sb.append(ch) ;
            }
            sb.append("ma") ;
            for( int j = 0 ; j<wordCnt ; j++ ){
                sb.append('a') ;
            }
            wordCnt++ ;
            if( i!=sentence.length() ){
                sb.append(" ");
            }
            i++ ;
        }
        return sb.toString() ;
    }
}
