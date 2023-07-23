package com.dhruv.company.accenture;

import java.util.ArrayList;
import java.util.List;

public class AndProof {
    public static void main(String[] args) {
        int[] ar = {1,2,3} ;
        int n = ar.length ;
        int res = longestSubarray(ar,n) ;
        System.out.println(res);
    }
    static int longestSubarray(int[]arr,int n){
        List<Integer> list = new ArrayList<>();
        int res = 0 ;
        for( int i = 0 ; i<n; i++ ){
            list.add(arr[i]) ;
            for( int j = i+1; j<n ; j++ ){
                list.add(arr[j]) ;
                if( isPos(list) ){
                    System.out.println(list);
                    res = Math.max(res,list.size()) ;
                }else{
                    break;
                }
            }
            list = new ArrayList<>();
        }
        return res ;
    }
    static boolean isPos(List<Integer> list ){
        for( int i = 0 ; i<list.size() ; i++ ){
            for( int j = i+1 ; j<list.size() ; j++ ){
                if( ( list.get(i) & list.get(j) )!= 0 ){
                    return false ;
                }
            }
        }
        return true ;
    }
}
