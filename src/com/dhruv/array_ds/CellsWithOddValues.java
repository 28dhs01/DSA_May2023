package com.dhruv.array_ds;

import java.util.Arrays;

public class CellsWithOddValues {
    public static void main(String[] args) {
        int m = 2 ;
        int n = 3 ;
        int [][] idcs =  {{0,1},{1,1}} ;
        System.out.println(oddCells(m,n,idcs));
    }
    public static int oddCells(int m, int n, int[][] indices) {
        int[][] mat = new int[m][n] ;
        for( int[] arr: indices ){
            int r = arr[0] ;
            int c = arr[1] ;
            for( int col = 0 ; col<mat[0].length ; col++ ){
                mat[r][col] += 1 ;
            }
            for( int row = 0 ; row<mat.length ; row++ ){
                mat[row][c] += 1 ;
            }
        }
        for ( int[]ar: mat){
            System.out.println(Arrays.toString(ar)) ;
        }
        int cnt = 0 ;
        for( int r = 0 ; r<m ; r++ ){
            for (int c=0 ; c<n ; c++ ){
                if( mat[r][c] % 2 != 0 ){
                    cnt++ ;
                }
            }
        }
        return cnt ;
    }
}
