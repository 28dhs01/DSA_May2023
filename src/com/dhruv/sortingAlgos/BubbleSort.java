package com.dhruv.sortingAlgos;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[]arr = {5,3,4,2,1} ;
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void bubbleSort(int[] heights){
        int n = heights.length ;
        boolean flag = false ;
        for( int i = 0 ; i<n ; i++ ){
            for (int j = 1 ; j<n-i ;j++ ){
                if( heights[j-1]>heights[j] ){
                    flag = true ;
                    swap(heights,j-1,j) ;
                }
            }
            if( flag == false ){
                break ;
            }
        }
    }
    static void swap(int[]arr, int f, int s){
        int temp = arr[f] ;
        arr[f] =arr[s] ;
        arr[s] = temp ;
    }
}
