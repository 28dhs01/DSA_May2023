package com.dhruv.hashmap_ds.questions;

import java.util.Arrays;
import java.util.HashMap;

public class LongestConsecutiveSeq {
    public static void main(String[] args) {
        int [] nums = {10,5,9,1,11,8,6,15,3,12,2};
        HashMap<Integer,Boolean> map = new HashMap<>();
        for( int e : nums ){
            map.put(e,true);
        }
//        System.out.println(map);
        for( int key: map.keySet() ){
            if( map.containsKey(key-1) ){
                map.put(key,false);
            }
        }
//        System.out.println(map);
        int maxLength = 0 ;
        int longSubStart = Integer.MIN_VALUE ;
        for( int key : map.keySet() ){
            if( map.get(key) == true){
                int startPt = key ;
                int len = 1 ;
                while (map.containsKey(key+len)){
                    len++ ;
                }
                if( len > maxLength ){
                    maxLength = len ;
                    longSubStart = startPt ;
                }
            }
        }
        int [] arr = new int[maxLength];
        for( int i = 0 ; i<arr.length ; i++ ){
            arr[i] = longSubStart+i ;
        }
        System.out.println(Arrays.toString(arr));
    }
}
