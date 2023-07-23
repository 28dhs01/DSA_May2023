package com.dhruv.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    public static void main(String[] args) {
        int k = 9 ;
        int n = 45 ;
        combinationSum3(k,n) ;
    }
    public static List<List<Integer>> combinationSum3(int k, int n) {
        int[] ar = new int[9] ;
        for( int i = 0 ; i<ar.length ; i++ ){
            ar[i] = i+1 ;
        }
        List<List<Integer>> outerList = new ArrayList<>() ;
        List<Integer> innerList = new ArrayList<>() ;
        makeList(ar,0,k,n,innerList,outerList) ;
        for( List<Integer> inList : outerList ){
            System.out.println(inList);
        }
        return outerList ;
    }
    static void makeList(int[]ar, int curIdx, int k , int n , List<Integer> innerList, List<List<Integer>> outerList ){
        if( innerList.size() == k ){
//            System.out.println("hi") ;
            List<Integer> dmyList = new ArrayList<>(innerList) ;
            int sum = 0 ;
            for( int i = 0 ; i<dmyList.size() ; i++ ){
                sum += dmyList.get(i) ;
            }
            // System.out.println(sum) ;
            if( sum == n && !outerList.contains(dmyList) ){
                outerList.add(dmyList) ;
            }
            return ;
        }
        if( curIdx == 9 ){
            return ;
        }
//        System.out.println(innerList) ;
        innerList.add(ar[curIdx]) ;
        makeList(ar,curIdx+1,k,n,innerList,outerList) ;
        innerList.remove(innerList.size()-1) ;
        makeList(ar,curIdx+1,k,n,innerList,outerList) ;
    }
}
