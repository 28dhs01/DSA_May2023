package com.dhruv.hashmap_ds.implementation;

import java.util.*;

public class HashMapWithDLL {
    public static void main(String[] args) {
        LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();
        int[] nums = {7,8,7,9} ;
        for( int i = 0 ; i<nums.length ; i++ ){
            int key = nums[i] ;
            if( map.containsKey(key) ){
                map.put(key,map.get(key)+1);
            }else{
                map.put(key,1) ;
            }
        }
        Iterator<Integer> keysArr = map.keySet().iterator() ;
        for (Iterator<Integer> it = keysArr; it.hasNext(); ) {
            Integer e = it.next();
            System.out.println(e);
        }
        System.out.println(Arrays.toString(new Iterator[]{keysArr}));
        int key = map.keySet().iterator().next() ;
        System.out.println(key);
        map.remove(key);
        int nkey = map.keySet().iterator().next() ;
        System.out.println(nkey);
    }
}
