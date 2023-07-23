package com.dhruv.hashmap_ds.leetcode;

import java.util.*;

public class LRUCache {
    public static void main(String[] args) {

    }

        LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>() ;
        int capacity ;
        public LRUCache(int capacity) {
            this.capacity = capacity ;
        }

        public int get(int key) {
            if(!map.containsKey(key)){
                return -1 ;
            }
            updateOrder(key) ;
            return map.get(key) ;
        }

        public void put(int key, int value) {
            if( map.containsKey(key) ){
                map.put(key,value) ;
                updateOrder(key);
            }
            else if( map.size() >= capacity ){
                int oldestOcc = map.keySet().iterator().next();
                map.remove(oldestOcc) ;
                map.put(key,value) ;
            }
            else{
                map.put(key,value) ;
            }
        }
        void updateOrder(int key){
            int val = map.get(key) ;
            map.remove(key) ;
            map.put(key,val) ;
        }

}
