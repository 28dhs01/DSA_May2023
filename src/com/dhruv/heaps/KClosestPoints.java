package com.dhruv.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestPoints {
    public static void main(String[] args) {
        int[][]points = {{1,3},{-2,2}};
        int k = 1 ;
//        int[][] points = {{3,3},{5,-1},{-2,4}};
//        int k = 2 ;
        int[][] ans = kClosest(points,k) ;
        for( int [] ar: ans ){
            System.out.println(Arrays.toString(ar));
        }
    }
    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> mnh = new PriorityQueue<>();
        for( int[] ar: points ){
            double dis = ar[0]*ar[0] + ar[1]*ar[1] ;
//            dis = Math.sqrt(dis) ;
//            System.out.println(dis);
            mnh.add(new Pair(ar,dis)) ;
        }
//        System.out.println(Arrays.toString( mnh.peek().ar) );
//        System.out.println(mnh.peek().dis);
        int[][] outerArr = new int[k][2] ;
        for( int r = 0 ; r<k ; r++ ){
            int f = mnh.peek().ar[0] ;
            int s = mnh.peek().ar[1] ;
            outerArr[r][0] = f ;
            outerArr[r][1] = s ;
            System.out.println(f+", "+ s);
            System.out.println(mnh.peek().dis);
            mnh.poll() ;
        }
//        System.out.println(mnh.peek().dis);

        return outerArr;
    }
    static class Pair implements Comparable<Pair>{
        int[] ar ;
        double dis ;
        Pair(int[] ar, double dis ){
            this.ar = ar ;
            this.dis = dis ;
        }

        @Override
        public int compareTo(Pair o) {
            double val = this.dis - o.dis ;
            return (int)(val) ;
        }
    }
}
