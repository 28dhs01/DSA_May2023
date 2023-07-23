package com.dhruv.algorithm;

public class KadanesAlgo {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4} ;
        int ans = maxSubArray(nums);
        System.out.println(ans);
    }
    public static int maxSubArray(int[] nums) {
        return kadane(nums);
    }
    static int kadane(int [] nums ){
        int curSum = 0 ;
        int mxSum = Integer.MIN_VALUE ;
        for( int i = 0 ; i<nums.length ; i++ ){
            curSum += nums[i];
            mxSum = Math.max(curSum,mxSum) ;
            if( curSum<0 ){
                curSum = 0 ;
            }
        }
        return curSum ;
    }
}
