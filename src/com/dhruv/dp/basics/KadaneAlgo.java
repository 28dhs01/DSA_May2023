package com.dhruv.dp.basics;

import java.util.Arrays;

public class KadaneAlgo {
    public static void main(String[] args) {
        int [] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int ans = bruteforce(nums) ;
        System.out.println(ans);
        int ans2 = kadane(nums) ;
        System.out.println(ans2);
    }
    static int bruteforce(int[]nums){
        int maxSum = Integer.MIN_VALUE ;
        int curSum = 0 ;
        for( int i = 0 ; i<nums.length ; i++ ){
            curSum = nums[i] ;
            if( curSum > maxSum ){
                maxSum = curSum ;
            }
            for( int j = i+1 ; j< nums.length ; j++ ){
                curSum += nums[j] ;
                if( curSum > maxSum ){
                    maxSum = curSum ;
                }
            }
        }
        return maxSum ;
    }
    static int kadane(int []nums){
        int curSum = 0 ;
        int maxSum = Integer.MIN_VALUE ;
        for( int i = 0 ; i< nums.length ; i++ ){
            curSum = curSum+nums[i] ;
            if( curSum > maxSum ){
                maxSum = curSum ;
            }
            if( curSum < 0 ){
                curSum = 0 ;
            }
        }
        return maxSum ;
    }
}
