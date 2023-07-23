package com.dhruv.heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MtxCellsInDistanceOrder {
    public static void main(String[] args) {
        int rows = 2, cols = 2, rCenter = 0, cCenter = 1 ;
        int[][] ans = allCellsDistOrder(rows,cols,rCenter,cCenter) ;
        for( int [] ar: ans ){
            System.out.println(Arrays.toString(ar));
        }
    }
    public static int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        PriorityQueue<Pair> mnh = new PriorityQueue<>();
        int [][] res = new int[rows*cols][2] ;
        for( int  r = 0 ;r<rows ; r++ ){
            for( int c = 0 ; c<cols ; c++ ){
                int[] ar = new int[2] ;
                ar[0] = r ;
                ar[1] = c ;
                int dis = Math.abs(r-rCenter) + Math.abs(c-cCenter) ;
                mnh.add(new Pair(ar,dis)) ;
            }
        }
        int i = 0 ;
        while( !mnh.isEmpty() ){
            Pair peek = mnh.peek() ;
            mnh.poll() ;
            res[i][0] = peek.ar[0] ;
            res[i][1] = peek.ar[1] ;
            i++ ;
        }
        return res ;
    }
    static class Pair implements Comparable<Pair>{
        int[] ar ;
        int dis ;
        Pair(int[]ar, int dis ){
            this.ar = ar ;
            this.dis = dis ;
        }

        @Override
        public int compareTo(Pair o) {
            return this.dis-o.dis;
        }
    }
}
