package com.dhruv.hashmap_ds.leetcode;

import java.util.HashMap;

public class IncreasingDecreasingString {
    public static void main(String[] args) {
        sortString("aaaaaabbbcc");
    }
    public static String sortString(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for( int i = 0 ; i<s.length() ; i++ ){
            char key = s.charAt(i) ;
            if( map.containsKey(key) ){
                map.put(key,map.get(key)+1);
            }
            else{
                map.put( key,1);
            }
        }
        System.out.println(map);
        String res = "";
        boolean oddLvl = false ;
        while( !map.isEmpty() ){
            if( oddLvl ){
                oddLvl = false ;
            }else{
                oddLvl = true ;
            }
            StringBuilder sb = new StringBuilder();
            for( char key: map.keySet() ){
                sb.append(key);
                map.put(key,map.get(key)-1);
                if( map.get( key ) == 0 ){
                    map.remove(key);
                }
            }
            if( oddLvl == false ){
                sb = sb.reverse();
            }
            res += sb ;
            System.out.println(res);
            System.out.println(map);
        }
        return res;
    }
}
