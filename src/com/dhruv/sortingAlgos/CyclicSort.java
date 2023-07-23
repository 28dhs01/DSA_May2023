package com.dhruv.sortingAlgos;

import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int[] ar = {3,5,2,1,4} ;
        cyclicSort(ar) ;
        System.out.println(Arrays.toString(ar));
    }
    static void cyclicSort(int[]ar){
        int i = 0 ;
        while( i<ar.length ){
            int correctIdx = ar[i] - 1 ;
            if( i != correctIdx ){
                swap(ar, i,correctIdx);
            }else{
                i++ ;
            }
        }
    }
    static void swap(int[]ar, int f , int s ){
        int temp = ar[f] ;
        ar[f] = ar[s] ;
        ar[s] = temp ;
    }
}
