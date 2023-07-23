package com.dhruv.algorithm;

import java.util.ArrayList;
import java.util.List;

public class PancakeSorting {
    public static void main(String[] args) {
        int[] ar = {3,2,4,1} ;
        List<Integer> list = pancakeSort(ar) ;
        System.out.println(list);
    }
    public static List<Integer> pancakeSort(int[] arr) {
        List<Integer> list = new ArrayList<>() ;
        int n = arr.length ;
        while( n!=1 ){
            int mxIdx = findMaxIdx(arr, n) ;
            reverse(arr,0,mxIdx) ;
            reverse(arr,0,n-1) ;
            list.add(mxIdx+1) ;
            list.add(n) ;
            n-- ;
        }
        return list ;
    }
    static int findMaxIdx(int[] ar, int n){
        int mxidx = 0 ;
        for( int i = 0 ; i<n ; i++ ){
            if( ar[i] > ar[mxidx] ){
                mxidx = i ;
            }
        }
        return mxidx ;
    }
    static void reverse(int[] arr, int s, int e){
        while( s<=e ){
            swap(arr,s,e) ;
            s++ ;
            e-- ;
        }
    }
    static void swap(int[] ar, int f, int s){
        int temp = ar[f] ;
        ar[f] = ar[s] ;
        ar[s] = temp ;
    }
}
