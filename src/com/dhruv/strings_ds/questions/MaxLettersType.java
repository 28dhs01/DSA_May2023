package com.dhruv.strings_ds.questions;

import java.util.ArrayList;

public class MaxLettersType {
    public static void main(String[] args) {
        String text = "hello world", brokenLetters = "ad" ;
        System.out.println(canBeTypedWords(text,brokenLetters));
    }
    public static int canBeTypedWords(String text, String brokenLetters) {
        ArrayList<String> list = totLetters(text) ;

        System.out.println(list);
        int cnt = 0 ;
        for( String word: list ){
            boolean flag = true ;
            for( int i = 0 ; i<word.length() ; i++ ){
                char ch = word.charAt(i) ;
                if( brokenLetters.contains(""+ch) ){
                    flag = false ;
                    break;
                }
            }
            if( flag == true ){
                cnt++ ;
            }
        }
        return cnt ;
    }
    static ArrayList<String> totLetters(String text){
        ArrayList<String> list = new ArrayList<>();
        String s = "" ;
        for( int i = 0 ; i<text.length() ; i++ ){
            char ch = text.charAt(i) ;
            if( ch == ' ' ){
                list.add(s);
                s = "" ;
            }else{
                s += ch ;
            }
        }
        list.add(s);
        return list;
    }

}
