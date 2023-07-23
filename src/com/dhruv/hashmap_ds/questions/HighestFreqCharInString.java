package com.dhruv.hashmap_ds.questions;

import java.util.HashMap;
import java.util.Set;

public class HighestFreqCharInString {
    public static void main(String[] args) {
        String str = "abrakadabra";
        HashMap<Character,Integer> map = new HashMap<>();
        for ( int i = 0 ; i<str.length() ; i++ ) {
            char ch = str.charAt(i);
            if(map.containsKey(ch) ){
                map.put(ch, map.get(ch)+1);
            }else{
                map.put(ch,1);
            }
        }
        System.out.println(map);
        Set<Character> set = map.keySet();
        char mostFreqChar = '0' ;
        int hiFreq = Integer.MIN_VALUE ;
        for (char key: set) {
            int val = map.get(key);
            if(val > hiFreq){
                hiFreq = val ;
                mostFreqChar = key ;
            }
        }
        System.out.println(mostFreqChar);
    }
}
