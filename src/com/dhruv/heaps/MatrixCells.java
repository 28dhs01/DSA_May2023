package com.dhruv.heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MatrixCells {
    public static void main(String[] args) {
        int[][] ans = allCellsDistOrder(3,5,2,3) ;
        for( int [] ar: ans ){
            System.out.println(Arrays.toString(ar));
        }
    }
    public static int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int[][] mat = new int[rows][cols] ;
        PriorityQueue<Pair> mnh = new PriorityQueue<>() ;

        for( int i = 0 ; i<rows ; i++ ){
            for( int j = 0 ; j<cols ; j++) {
                int[]cordinates = new int[2] ;
                cordinates[0] = i ;
                cordinates[1] = j ;
                double dis = Math.sqrt( (i-rCenter)*(i-rCenter) + (j-cCenter)*(j-cCenter) ) ;
                Pair p = new Pair(cordinates,dis) ;
                mnh.add(p) ;
            }
        }
        int[][] ans = new int[rows*cols][2] ;
        int i = 0 ;
        while( !mnh.isEmpty() ){
            Pair p = mnh.poll() ;
            ans[i][0] = p.cordinates[0] ;
            ans[i][1] = p.cordinates[1] ;
            i++ ;
        }
        return ans ;
    }
    static class Pair implements Comparable<Pair> {
        int[] cordinates ;
        double dis ;
        Pair(int[]cordinates, double dis){
            this.cordinates = cordinates ;
            this.dis = dis ;
        }
        @Override
        public int compareTo(Pair o){
            if( this.dis < o.dis ){
                return -1 ;
            }
            if( this.dis > o.dis ){
                return 1 ;
            }
            return 0 ;
//            return (int) (this.dis - o.dis) ;
        }
    }
}
