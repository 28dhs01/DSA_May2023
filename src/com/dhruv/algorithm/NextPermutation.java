package com.dhruv.algorithm;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = {1,3,5,4,2} ;
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void nextPermutation(int[] nums) {
        int firstIdx = -1 ;
        for( int i = nums.length-1 ; i>0 ; i-- ){
            if( nums[i-1] < nums[i] ){
                firstIdx = i-1 ;
                break;
            }
        }
        if( firstIdx != -1 ){
            int secondIdx = -1 ;
            for( int i = nums.length-1 ; i>=0 ; i-- ){
                if( nums[i] > nums[firstIdx] ){
                    secondIdx = i ;
                    break;
                }
            }
            swap(nums,firstIdx,secondIdx);
            reverse(nums,firstIdx+1,nums.length-1);

        }else{
            reverse(nums,0,nums.length-1);
        }
    }
    static void swap(int[]ar, int f, int s){
        int temp = ar[f] ;
        ar[f] = ar[s] ;
        ar[s] = temp ;
    }
    static void reverse(int[]ar, int s, int e){
        while( s<=e ){
            swap(ar,s,e);
            s++ ;
            e-- ;
        }
    }
}
