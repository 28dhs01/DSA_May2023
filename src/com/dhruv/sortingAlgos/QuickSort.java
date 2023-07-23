package com.dhruv.sortingAlgos;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] ar = {15,20,17,19,7,6} ;
        quickSort(ar,0,ar.length-1);
        System.out.println(Arrays.toString(ar));
    }
    static void quickSort(int[] nums, int lo, int hi){
        if( lo >= hi ){
            return;
        }
        int s = lo ;
        int e = hi ;
        int m = s+(e-s)/2 ;
        int pivot = nums[m] ;
        while( s<=e ){
            while( nums[s] < pivot ){
                s++ ;
            }
            while( nums[e] > pivot ){
                e-- ;
            }
            if( s<=e ){
                swap(nums,s,e) ;
                s++ ;
                e-- ;
            }
        }
        quickSort(nums,lo,e);
        quickSort(nums,s,hi);
    }
    static void swap(int[]ar, int f, int s ){
        int temp = ar[f] ;
        ar[f] = ar[s] ;
        ar[s] = temp ;
    }
}
