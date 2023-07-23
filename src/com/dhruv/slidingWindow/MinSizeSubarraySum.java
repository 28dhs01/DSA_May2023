package com.dhruv.slidingWindow;

public class MinSizeSubarraySum {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int target = 7 ;
        int ans = minSubArrayLen(target,nums);
        System.out.println(ans);
        int ans2 = slidingWindow(target,nums);
        System.out.println(ans2);
    }
    public static int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE ;

        for( int i = 0 ; i<nums.length ; i++ ){
            int innerSum = 0 ;
            int ctr = 0 ;
            for( int j = i ; j<nums.length ; j++ ){
                innerSum += nums[j];
                ctr ++ ;
                if( innerSum >= target ){
                    ans = Math.min(ctr,ans);
                    break;
                }
            }
        }
        return ans ;
    }
    public static int slidingWindow(int target, int[] nums ){
        int ans = Integer.MAX_VALUE ;
        int i = 0 ;
        int j = 0 ;
        int curSum = 0 ;
        while ( j<nums.length ){
            curSum += nums[j];
            while(curSum >= target && i <= j){
                ans = Math.min(ans, j - i + 1);
                curSum -= nums[i];
                i++;
            }

            j++ ;
        }
        if( ans==Integer.MAX_VALUE ){
            return 0 ;
        }
        return ans ;
    }
}
