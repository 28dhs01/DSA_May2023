package com.dhruv.binary_search;

import java.util.ArrayList;
import java.util.Arrays;

public class KWeakestRows {
    public static void main(String[] args) {
        int[][] mat = {
                {1,1,0,0,0},
                {1,1,1,1,0},
                {1,0,0,0,0},
                {1,1,0,0,0},
                {1,1,1,1,1}
        };
        int k = 3 ;
        int [] ans = kWeakestRows(mat,k);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] kWeakestRows(int[][] mat, int k) {
        ArrayList<Integer> soldiers = new ArrayList<>();
        for( int i = 0 ; i<mat.length ; i++ ){
            int soldier = 0 ;
            for( int j = 0 ; j<mat[i].length ; j++ ){
                if( mat[i][j] == 1 ){
                    soldier++ ;
                }
                if( j==mat[i].length-1){
                    soldiers.add(soldier) ;
                }
            }
        }
        System.out.println(soldiers);

        int[] ans = new int[k] ;
        boolean [] visited = new boolean[soldiers.size()];
        for( int i = 0 ; i<k ;i++ ){
            int cnt = Integer.MAX_VALUE ;
            for( int j = 0; j<soldiers.size() ; j++ ){
                if( soldiers.get(j) < cnt && visited[j] == false){
                    cnt = soldiers.get(j) ;
                    ans[i] = j ;
                }
                if ( j==soldiers.size()-1 ){
                    visited[ans[i]] = true ;
                }
            }
        }
        return ans;
    }
}
