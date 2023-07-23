package com.dhruv.hashmap_ds.leetcode;

import java.util.*;

public class ThreeDigitEven {
    public static void main(String[] args) {
        int [] digits = {2,1,3,0} ;
        int[]res = findEvenNumbers(digits) ;
        System.out.println(Arrays.toString(res));
    }
    public static int[] findEvenNumbers(int[] digits) {
        Map<Integer,Integer> map = new HashMap<>() ;
        for( int i = 0 ; i<digits.length ; i++ ){
            int key = digits[i] ;
            if( map.containsKey(key) ){
                map.put(key,map.get(key)+1) ;
            }else{
                map.put(key,1) ;
            }
        }
        System.out.println(map) ;
        List<Integer> list = new ArrayList<>() ;
        for( int i = 100 ; i<999 ; i=i+2 ){
            // System.out.println(i) ;
            if(check(i,map) == true ){
                list.add(i) ;
            }
        }
        System.out.println(list) ;
        int[] res = new int[list.size()] ;
        for( int i = 0 ; i<res.length ; i++ ){
            res [i] = list.get(i) ;
        }
        return res ;
    }
    static boolean check(int num, Map<Integer, Integer> map){
        Map<Integer,Integer> dmy = new HashMap<>(map) ;
        // System.out.println(dmy) ;
        while( num>0 ){
            int dgt = num%10 ;
            if( !dmy.containsKey(dgt) ){
                return false ;
            }
            if( dmy.get(dgt) == 0 ){
                return false ;
            }
            dmy.put(dgt,dmy.get(dgt)-1) ;
            num = num/10 ;
        }
        return true ;
    }
}
