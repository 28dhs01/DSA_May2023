package com.dhruv.matrix;

import java.util.Arrays;

public class LargestLocalValues {
    public static void main(String[] args) {
        int[][] grid = {
                {9,9,8,1},{5,6,2,6},{8,2,6,4},{6,2,2,2}
        } ;
        int[][] res = largestLocal(grid) ;
        for( int [] ar: res ){
            System.out.println(Arrays.toString(ar));
        }
    }
    public static int[][] largestLocal(int[][] grid) {
        int n = grid.length ;
        int [][] res = new int[n-2][n-2] ;
        int rs = 0 ;
        int cs = 0 ;
        int i = 0 ;
        int j = 0 ;
        while( rs+3 <= n ){
            while( cs+3 <= n ){
                int mx = find(grid,rs,cs) ;
                res[i][j] = mx ;
                j++ ;
                cs++ ;
            }
            rs++ ;
            cs = 0 ;
            j = 0 ;
            i++ ;
        }
        return res ;
    }
    static int find(int[][] grid,int rs, int cs){
        int mx = Integer.MIN_VALUE ;
        for( int r = rs ; r<rs+3; r++ ){
            for( int c = cs ; c<cs+3 ; c++ ){
                mx = Math.max(mx,grid[r][c]) ;
            }
        }
        return mx ;
    }
}
