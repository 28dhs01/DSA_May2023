package com.dhruv.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountLargestGroup {
    public static void main(String[] args) {
        int n = 13 ;
        int ans = countLargestGroup(n) ;
        System.out.println(ans);
    }
    public static int countLargestGroup(int n) {
//        int[] ar = new int[size]
        List<Integer>[] ar = new ArrayList[50];
        for( int i = 0 ; i<ar.length ; i++ ){
            ar[i] = new ArrayList<>() ;
        }
        for( int i = 0 ; i<=n ; i++ ){
            int dgtSum = digitSum(i) ;
            List<Integer> list = ar[dgtSum] ;
            list.add(i) ;
        }

        System.out.println(Arrays.toString(ar)) ;
        int mxListSize = 0 ;
        for( int i = 0 ; i<ar.length ; i++ ){
            List<Integer> list = ar[i] ;
            if( list.size() > mxListSize ){
                mxListSize = list.size() ;
            }
        }
        int cntMxLstSize = 0 ;
        for( int i = 1 ; i<ar.length ; i++ ){
            List<Integer> list = ar[i] ;
            if( list.size() == mxListSize ){
                cntMxLstSize++ ;
            }
        }
        return cntMxLstSize ;
    }
    static int digitSum(int n){
        int dgtSum = 0 ;
        while( n>0 ){
            int dgt = n%10 ;
            dgtSum += dgt ;
            n /= 10 ;
        }
        return dgtSum ;
    }
}
