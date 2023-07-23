package com.dhruv.hashmap_ds.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class GetCommonElement1 {
    public static void main(String[] args) {
        int [] nums1 = {4,9,5};
        int [] nums2 = {9,4,9,8,4};
        HashMap<Integer,Integer> map1 = new HashMap<>();
        HashMap<Integer,Integer> map2 = new HashMap<>();
        for(int i = 0 ; i< nums1.length ; i++ ){
            int key = nums1[i] ;
            if(map1.containsKey(key)){
                int of = map1.get(key) ;
                map1.put(key,of+1);
            }else{
                map1.put(key,1);
            }
        }
        System.out.println(map1);
        for(int i = 0 ; i< nums2.length ; i++ ){
            int key = nums2[i] ;
            if(map2.containsKey(key)){
                int of = map2.get(key) ;
                map2.put(key,of+1);
            }else{
                map2.put(key,1);
            }
        }
        System.out.println(map2);
        ArrayList<Integer> list = new ArrayList<>();
        for( int key : map2.keySet() ){
            if(map1.containsKey(key)){
                list.add(key);
            }
        }
        System.out.println(Arrays.toString(list.toArray()));
    }
}
