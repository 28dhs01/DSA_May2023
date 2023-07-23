package com.dhruv.hashmap_ds.leetcode;

import java.util.HashMap;

public class ContiguousSubarray {
    public static void main(String[] args) {
        int[] nums = {23,2,4,6,6} ;
        int k = 7 ;
        boolean ans = checkSubarraySum(nums,k);
        System.out.println(ans);
    }
    public static boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>() ;
        int sum = 0 ;
         map.put(0,-1) ;
        for( int i = 0 ; i<nums.length ; i++ ){
            sum += nums[i] ;
            int rem = sum%k ;
            int idx = i ;
            int key = rem ;
            int val = idx ;
            if( map.containsKey(key) ){
                if( val - map.get(key) >=2 ){
                    return true ;
                }
            }else{
                map.put(key,val) ;
            }
        }
        return false ;
    }
}
