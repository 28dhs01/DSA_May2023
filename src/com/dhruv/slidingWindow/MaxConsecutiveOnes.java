package com.dhruv.slidingWindow;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0} ;
        int k = 2 ;
        int ans = longestOnes(nums,k );
        System.out.println(ans);
    }
    public static int longestOnes(int[] nums, int k) {
        int i = 0 ;
        int j = 0 ;
        int ans = 0 ;
        int count0 = 0 ;
        while( j<nums.length ){
            if( nums[j] == 0 ){
                count0 ++ ;
            }
            if( count0>k ){
                int winds = j-1-i+1;
                ans = Math.max(ans,winds);
                while( nums[i] != 0 ){
                    i++ ;
                }
                i++ ;
                count0--;
            }
            j++ ;
        }
        return ans ;
    }
}
