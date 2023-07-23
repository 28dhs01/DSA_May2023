package com.dhruv.recursion;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {
    public static void main(String[] args) {
        int[][] heights = {
                {1,2,2,3,5},
                {3,2,3,4,4},
                {2,4,5,3,1},
                {6,7,1,4,5},
                {5,1,1,2,4}
        } ;
        List<List<Integer>> res = pacificAtlantic(heights) ;
        for( List<Integer>list: res ){
            System.out.println(list);
        }
    }
    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> outerList = new ArrayList<>() ;
        int m = heights.length ;
        int n = heights[0].length ;
        boolean [][] visited = new boolean[m][n] ;
        for( int r = 0 ; r<heights.length ; r++ ){
                 for( int c = 0 ; c<heights[0].length ; c++ ){
                     visited = new boolean[m][n] ;
                     top = false ;
                     left = false ;
                     right = false ;
                     down = false ;
                     isPossible(heights,visited,r,c,heights[r][c]) ;
                     if( ( top == true || left == true ) && ( right == true || down == true ) ){
                         List<Integer> list = new ArrayList<>() ;
                         list.add(r) ;
                         list.add(c) ;
                         outerList.add( list ) ;
                     }
                 }
        }
        return outerList ;
    }
    static boolean top = false ;
    static boolean right = false ;
    static boolean down = false ;
    static boolean left = false ;
    static void isPossible( int[][] heights , boolean[][] visited, int r, int c, int cur ){
        if( r<0 ){
            top = true ;
            return;
        }
        if( r>=heights.length ){
            down = true ;
            return;
        }
        if( c<0 ){
            left = true ;
            return;
        }
        if( c>=heights[0].length) {
            right = true ;
            return;
        }
        if( visited[r][c] == true || heights[r][c] > cur ){
            return  ;
        }
        visited[r][c] = true ;
//         top
         isPossible( heights, visited,r-1,c,heights[r][c]) ;
//         right
         isPossible( heights,visited,r,c+1,heights[r][c]) ;
//         left
         isPossible( heights,visited,r,c-1,heights[r][c] );
//         down
         isPossible(heights,visited,r+1,c,heights[r][c]) ;

    }
}
