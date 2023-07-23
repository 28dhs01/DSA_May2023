package com.dhruv.recursion;

public class NQueens2 {
    public static void main(String[] args) {
        int n = 2 ;
        int ans = totalNQueens(n) ;
        System.out.println(ans);
    }
    static int cnt = 0 ;
    static int queensUsed = 0 ;
    static int totalNQueens(int n ){
        boolean[][] mat = new boolean[n][n] ;
        int r = 0 ;
        countWays(mat,r) ;
        return cnt ;
    }
    static void countWays(boolean[][]mat, int r){
        if( r == mat.length && queensUsed == mat.length ){
            cnt++ ;
            return;
        }
        for( int c = 0 ; c<mat[0].length ; c++ ){
            boolean isSafe = isSafe(mat,r,c) ;
            if( isSafe == true ){
                mat[r][c] = true ;
                queensUsed++ ;
                countWays(mat,r+1);
                queensUsed-- ;
                mat[r][c] = false ;
            }
        }
    }
    static boolean isSafe(boolean[][] mat,int r, int c){
//        top
        for( int row= 0 ; row<r ; row++ ){
            if( mat[row][c] == true ){
                return false ;
            }
        }
//        left diagonal
        int mxLeft = Math.min(r,c) ;
        for( int i = 1 ; i<=mxLeft ; i++ ){
            if( mat[r-i][c-i] == true ){
                return false ;
            }
        }
        int mxRight = Math.min(r,mat.length-c-1) ;
        for( int i = 1 ; i<= mxRight; i++ ){
            if( mat[r-i][c+i] == true ){
                return false ;
            }
        }
        return true ;
    }
}
