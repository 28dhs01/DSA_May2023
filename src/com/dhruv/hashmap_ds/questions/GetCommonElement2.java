package com.dhruv.hashmap_ds.questions;

import java.util.ArrayList;
import java.util.HashMap;

public class GetCommonElement2 {
    public static void main(String[] args) {
        int[] nums1 = {1,1,1,2,2,4,3};
        int[] nums2 = {7,6,1,1,2,2,2,8};
        HashMap<Integer,Integer> map1 = new HashMap<>();
        for( int val : nums1 ){
            if(map1.containsKey(val)){
                int of = map1.get(val);
                map1.put(val,of+1);
            }else{
                map1.put(val,1);
            }
        }
        HashMap<Integer,Integer> map2 = new HashMap<>();
        for( int val : nums2 ){
            if( map2.containsKey(val)){
                int of = map2.get(val);
                map2.put(val,of+1);
            }else {
                map2.put(val,1);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int key: map2.keySet()) {
            if( map1.containsKey(key) ){
                int f1 = map1.get(key) ;
                int f2 = map2.get(key) ;
                int minFreq = Math.min(f1,f2);
                for( int i = 0 ; i<minFreq ; i++ ){
                    list.add(key);
                }
            }
        }
        System.out.println(list);
    }
}
