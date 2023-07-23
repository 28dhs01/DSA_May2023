package com.dhruv.company.accenture;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;

public class MajorityElement {
    public static void main(String[] args) {
        int[] ar = {1,3,3,2,1,3,1,3,3,3} ;
        int n = ar.length ;
        int ans = majorityElement(ar,n) ;
        System.out.println(ans);
    }
    static int majorityElement(int[]arr, int n ){
        if( arr.length == 0 ){
            return -2 ;
        }
        HashMap<Integer,Integer> map = new HashMap<>() ;
        for( int i = 0 ; i<arr.length ; i++ ){
            if( map.containsKey(arr[i]) ){
                map.put(arr[i],map.get(arr[i])+1) ;
            }else{
                map.put(arr[i],1) ;
            }
        }
        int half = n/2 ;
        for( int key: map.keySet() ){
            if( map.get(key) > half ){
                return key ;
            }
        }
        return -1 ;
    }
}
