package com.dhruv.two_pointer;

public class LongestMountainInArray {
    public static void main(String[] args) {
        int[] ar = {2,1,4,7,3,2,5} ;
//        int[] ar = {2,2,2} ;
//        int [] ar = {0,1,2,3,4,5,6,7,8,9} ;
//        int [] ar = {2,3,1,2,3,4,5,6} ;
        int ans = longestMountain(ar) ;
        System.out.println(ans);
    }
    public static int longestMountain(int[] arr) {
        int p1 = 0 ;
        int p2 = 1 ;
        int mxsize = 0 ;
        while( p2<arr.length ){
            int size = 1 ;
            boolean inc = false ;
            boolean dec = false ;
            while( p2<arr.length && arr[p1] < arr[p2] ){
                inc = true ;
                p1 = p2 ;
                p2++ ;
                size++ ;
            }
            while ( p2<arr.length && arr[p1] > arr[p2] ){
                dec = true ;
                p1 = p2 ;
                p2++ ;
                size++ ;
            }
            if( p2<arr.length && arr[p1] == arr[p2] ){
                p1 = p2 ;
                p2++ ;
            }
            boolean mountainFormed = false ;
            if( inc == true && dec == true ){
                mountainFormed = true ;
            }
            if(  size < 3 || !mountainFormed  ){
                mxsize = mxsize ;
            }
            else{
                mxsize = Math.max(size,mxsize) ;
            }
        }
        return mxsize ;
    }
}
