package com.dhruv.hashmap_ds.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class TownJudge {
    public static void main(String[] args) {
        int[][]trust = {
//                {1,3},
//                {1,4},
//                {2,3},
//                {2,4},
//                {4,3}
//                {1,2},
//                {2,3}
                {1,3},
                {2,3}
        };
        int n = 3 ;
        int ans = findJudge(n,trust);
        System.out.println(ans);
    }
    public static int findJudge(int n, int[][] trust) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        for( int[]ar: trust){
            int cm = ar[0] ;
            int ptAns = ar[1];
            s1.add(cm);
            s2.add(ptAns);
            int key = cm ;
            int val = ptAns;
            if( map.containsKey(key) ){
                ArrayList<Integer> inList = map.get(key) ;
                inList.add(val) ;
                map.put(key,inList);
            }else{
                ArrayList<Integer> inList = new ArrayList<>();
                inList.add(val);
                map.put(key,inList);
            }
        }
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(map);
        int ans = -1 ;
        for( int e: s2 ){
            if( !s1.contains(e) ){
                for( int i = 1; i<=n && i!=e ;i++ ){
                    int key = i ;
                    ArrayList<Integer> inList = map.get(key) ;
                    if( !inList.contains(e)) {
                        return -1 ;
                    }
                }
                ans = e;
            }
        }
        return ans ;
    }
}
