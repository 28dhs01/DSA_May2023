package com.dhruv.matrix;

public class ToeplitzMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,1,2,3},{9,5,1,2}} ;

    }
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length ;
        int n = matrix[0].length ;
        for( int r = m-1 ; r>=0 ; r-- ){
            int val = matrix[r][0] ;
            int myR = r ;
            myR++ ;
            for( int c = 1 ; c<n && myR<m ; c++ ){
                if( matrix[myR][c] != val ){
                    return false ;
                }
                myR++ ;
            }
        }
        for( int c = n-1 ; c>0 ; c-- ){
            int val = matrix[0][c] ;
            int myC = c ;
            myC++ ;
            for( int r = 1 ; r<m && myC<n ; r++ ){
                if( val != matrix[r][myC] ){
                    return false ;
                }
                myC++ ;
            }
        }
        return true ;
    }
}
