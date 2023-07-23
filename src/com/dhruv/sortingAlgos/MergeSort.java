package com.dhruv.sortingAlgos;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {8,3,4,2,5,6} ;
        int[] ans = mergeSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(ans));
    }
    static int[] mergeSort(int[] nums, int s, int e) {
        if( s==e ){
            return new int[]{nums[s]} ;
        }
        int m = (s+e)/2 ;
        int[] left = mergeSort(nums,s,m) ;
        int[] right = mergeSort(nums,m+1,e);
        int[] ans = merge(left,right) ;
        return ans ;
    }
    static int[] merge(int[] left , int [] right ){
        int[] mgd = new int[left.length+right.length] ;
        int i = 0 ;
        int j = 0 ;
        int k = 0 ;
        while(i<left.length && j<right.length) {
            if( left[i] < right[j] ){
                mgd[k] = left[i] ;
                i++ ;

            }else{
                mgd[k] = right[j];
                j++ ;
            }
            k++ ;
        }
        while( i<left.length ){
            mgd[k] = left[i] ;
            i++ ;
            k++ ;
        }
        while( j< right.length ){
            mgd[k] = right[j];
            j++ ;
            k++ ;
        }
        return mgd ;
    }

}
