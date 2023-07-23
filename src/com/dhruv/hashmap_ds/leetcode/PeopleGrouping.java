package com.dhruv.hashmap_ds.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PeopleGrouping {
    public static void main(String[] args) {
        int[] groupSizes = {3,3,3,3,3,1,3};
        System.out.println(groupThePeople(groupSizes));
    }
    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        HashMap<Integer, List<Integer>> map = new HashMap<>() ;
        List<List<Integer>> ansList = new ArrayList<List<Integer>>();
        for( int i = 0 ; i<groupSizes.length ; i++ ){
            int key = groupSizes[i] ;
            int val = i ;
            if ( map.containsKey(key) ){
                List<Integer> list = map.get(key);
                list.add(val);
                if( list.size() == key ){
                    ansList.add(list);
                    map.remove(key);
                }
                else{
                    map.put(key,list);
                    if( list.size() == key ){
                        ansList.add(list);
                        map.remove(key);
                    }
                }
            }else{
                List<Integer> list = new ArrayList<>() ;
                list.add( val );
                map.put( key, list);
            }
        }
        System.out.println(map);
        for( int key: map.keySet() ){
            List<Integer> lst = map.get(key) ;
            ansList.add(lst);
        }

        return ansList ;
    }
}
