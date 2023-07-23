package com.dhruv.slidingWindow;

import java.util.ArrayList;

public class SumOfOddLenSubArrays {
    public static void main(String[] args) {
        int[]arr = {1,4,2,5,3} ;
        int ans = sumOddLengthSubarrays(arr) ;
        System.out.println(ans);
    }
    public static int sumOddLengthSubarrays(int[] arr) {
        int ans = 0 ;
        for( int size = 1 ; size<=arr.length ; size = size+2 ){
            ans += slidingWindow(arr,size) ;
        }
        return ans ;
    }
    static int slidingWindow(int[]arr, int size){
        int i = 0 ;
        int j = 0 ;
        int sum = 0 ;
        ArrayList<Integer> lst = new ArrayList<>() ;
        while( j<arr.length ){
            sum += arr[j] ;
            if( j-i+1 == size ){
                lst.add(sum) ;
                sum -= arr[i] ;
                i++ ;
            }
            j++ ;
        }
        int res = 0 ;
        System.out.println(lst) ;
        for( int item: lst ){
            res += item ;
        }
        return res ;
    }
}
