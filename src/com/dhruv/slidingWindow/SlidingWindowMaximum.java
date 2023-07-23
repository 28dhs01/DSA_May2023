package com.dhruv.slidingWindow;

import java.util.*;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int [] nums = {1,3,1,2,0,5};
        int [] ans = maxSlidingWindow(nums,3);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length-k+1];
        int i = 0 ;
        int j = 0 ;
        Queue<Integer> q = new ArrayDeque<>() ;
        while( j<nums.length ){
            if( q.isEmpty() ){
                q.add(nums[j]);
            }else{

                for( int e: q ){
                    if( nums[j] > e ){
                        q.remove(e);
                    }
                }
//                while( !q.isEmpty() && nums[j] > q.peek() ){
//                    q.poll() ;
//                }
                q.add(nums[j]) ;
            }
            if ( j-i+1 == k ){
//                System.out.println(q);
                ans[i] = q.peek() ;
                if( q.peek() == nums[i] ){
                    q.poll() ;
                }
                i++ ;
            }
            j++ ;
        }
        return ans ;
    }
}
