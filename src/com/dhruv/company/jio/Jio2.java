package com.dhruv.company.jio;

public class Jio2 {
    public static void main(String[] args) {
        char [] ch = {'a','V' ,'K', 'E', 'l'} ;
        int ans = helper(ch) ;
        System.out.println(ans);
    }
    static int helper(char[] productID){
        int nonVowel = 0 ;
        for( char ch : productID ){
            ch = Character.toLowerCase(ch);
            if( ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                continue;
            }else {
                nonVowel++ ;
            }
        }
        return nonVowel ;
    }
}
