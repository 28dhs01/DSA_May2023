package com.dhruv.sortingAlgos;

import java.util.Arrays;

public class InPlaceMergeSort {
    public static void main(String[] args) {
        int[] nums = {10,7,6,5,3,8,2,1} ;
        inPlace(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
    static void inPlace(int[]nums,int s, int e){
        if( s==e ){
            return;
        }
        int m = (s+e)/2 ;
        inPlace(nums,s,m);
        inPlace(nums,m+1,e);
        merge(nums,s,m,e) ;
    }
    static void merge( int[]nums, int s, int m , int e ){
        int[] mix = new int[e-s+1] ;
        int i = s ;
        int j = m+1 ;
        int k = 0 ;
        while( i<=m && j<=e ){
            if( nums[i] < nums[j] ){
                mix[k] = nums[i] ;
                i++ ;
            }else{
                mix[k] = nums[j] ;
                j++ ;
            }
            k++ ;
        }
        while( i<= m ){
            mix[k] = nums[i] ;
            i++ ;
            k++ ;
        }
        while ( j<= e ){
            mix[k] = nums[j] ;
            j++ ;
            k++ ;
        }
        for( int l = 0 ; l<mix.length ; l++ ){
            nums[s+l] = mix[l] ;
        }
    }
}
