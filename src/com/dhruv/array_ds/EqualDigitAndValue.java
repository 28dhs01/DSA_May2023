package com.dhruv.array_ds;

import java.util.HashMap;

public class EqualDigitAndValue {
    public static void main(String[] args) {
        System.out.println( digitCount("1210"));
        int val = '2'-'0' ;
    }
    public static boolean digitCount(String num) {
        HashMap<Character, Integer> map = new HashMap<>() ;
        for( int i = 0 ; i<num.length() ;i++ ){
            char key = num.charAt(i) ;
            if( map.containsKey(key) ){
                map.put(key,map.get(key)+1);
            }else{
                map.put(key,1) ;
            }
        }
//        System.out.println(map) ;

         for( int i = 0 ; i<num.length() ; i++ ){
             char key = (i+"").charAt(0) ;
//             System.out.println(key);
             int val = Integer.parseInt(""+num.charAt(i));
//             System.out.println(val);
             if( map.containsKey(key) == false ){
                 map.put(key,0) ;
             }
             if( map.get(key) != val ) {
                 System.out.println("I");
                 return false ;
             }
         }
        return true ;
    }
}
