package com.dhruv.array_ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KthSmallestSumWithSortedRows {
    public static void main(String[] args) {
        int[][] mat = {{1,10,10},{1,4,5},{2,3,6}} ;
        int k = 7 ;
        int ans = kthSmallest(mat,k) ;
        System.out.println(ans);
    }
    public static int kthSmallest(int[][] mat, int k) {
        if( mat.length == 0 || mat[0].length == 0 || k>mat.length*mat[0].length ){
            return 0 ;
        }
        List<Integer> list = new ArrayList<>();
        for( int c = 0 ; c<mat[0].length ; c++ ){
            list.add(mat[0][c]) ;
        }
        for( int i = 1 ; i<mat.length ; i++ ){
            int [] ar = mat[i] ;
            List<Integer> temp = new ArrayList<>();
            for( int num: list ){
                for( int x: ar ){
                    temp.add(num+x) ;
                }
            }
            Collections.sort(temp);
            list.clear();
            for( int j = 0 ;j < Math.min(k,temp.size()) ; j++ ){
                list.add(temp.get(j)) ;
            }
        }
        return list.get(k-1) ;
    }

}
