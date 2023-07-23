package com.dhruv.hashmap_ds.leetcode;

import java.util.HashMap;

public class JewelsAndStones {
    public static void main(String[] args) {
        int ans = numJewelsInStones("aA","aaAbbb");
        System.out.println(ans);
    }
    static public int numJewelsInStones(String jewels, String stones) {
        HashMap<Character,Integer> map = new HashMap<>();
        for( int i = 0 ; i<jewels.length() ; i++ ){
            map.put(jewels.charAt(i),0);
        }
        System.out.println(map);
        for( int i = 0 ; i<stones.length() ; i++ ){
            if( map.containsKey(stones.charAt(i))){
                map.put(stones.charAt(i),map.get(stones.charAt(i))+1);
            }
        }
        System.out.println(map);
        int num_of_jewels = 0 ;
        for ( Character key: map.keySet() ) {
            num_of_jewels += map.get(key) ;
        }
        return num_of_jewels ;

    }
}
