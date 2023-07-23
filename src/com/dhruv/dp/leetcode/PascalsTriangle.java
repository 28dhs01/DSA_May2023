package com.dhruv.dp.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        int n = 5 ;
        List<List<Integer>> ansList = new ArrayList<>();
        for( int i = 0 ; i<n ;i++ ){
            List<Integer> innerList = new ArrayList<>();
            if( i == 0 ){
                innerList.add(1);
                ansList.add(innerList);
            }
            else if( i == 1 ){
                innerList.add(1);
                innerList.add(1);
                ansList.add(innerList);
            }else{
                innerList.add(1);
                List<Integer> prevList = ansList.get(i-1);
                for( int j = 1 ; j<i ; j++ ){
                    int fst = prevList.get(j-1);
                    int scd = prevList.get(j);
                    innerList.add(fst+scd);
                }
                innerList.add(1);
                ansList.add(innerList);
            }
        }
        System.out.println(ansList);
    }
}
