package com.dhruv.slidingWindow;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LongestContinuousSubarrayWithAbsDiffLessThanEqualLimit {
    public static void main(String[] args) {
        int[] nums = {1,5,6,7,8,10,6,5,6} ;
        int limit = 4 ;
        int ans = longestSubarray(nums,limit) ;
        System.out.println(ans);
    }
    public static int longestSubarray(int[] nums, int limit) {
        int ptr1 = 0 ;
        int ptr2 = 0 ;
        int longestSize = 0 ;
        PriorityQueue<Integer> mxh = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> mnh = new PriorityQueue<>(Comparator.reverseOrder()) ;
        int mxsf = nums[ptr1] ;
        int mnsf = nums[ptr1] ;
        while( ptr2 < nums.length ){
            mxsf = Math.max(mxsf,nums[ptr2]) ;
            mnsf = Math.min(mnsf,nums[ptr2]) ;
            mxh.add(nums[ptr2]) ;
            mnh.add(nums[ptr2]) ;
            if( mxsf - mnsf <= limit ){
                int size = ptr2 - ptr1 + 1 ;
                longestSize = Math.max(size,longestSize) ;
                ptr2++ ;
            }else{
                ptr1++ ;
                mxh.remove(nums[ptr1]) ;
                mnh.remove(nums[ptr1]) ;
                if( !mxh.isEmpty() && !mnh.isEmpty() ) {
                    mxsf = nums[mxh.peek()] ;
                    mnsf = nums[mnh.peek()] ;
                }
            }
        }
        return longestSize ;
    }
    static int findMax(int [] nums , int s , int e){
        int mx = nums[s] ;
        for( int i = s+1 ; i<=e ; i++ ){
            mx = Math.max(mx,nums[i]) ;
        }
        return mx ;
    }
    static int findMin(int[]nums,int s,int e){
        int mn = nums[s] ;
        for( int i = s ; i<=e ; i++ ){
            mn = Math.min(mn,nums[i]) ;
        }
        return mn ;
    }
}
