package com.dhruv.binary_search;

public class RBSWithDuplicates {
    public static void main(String[] args) {
        int[] nums = {1,1} ;
        int ans = findMin(nums) ;
        System.out.println(ans);
    }
    public static int findMin(int[] nums) {
        int s = 0;
        int e = nums.length - 1;
        int pivot = 0;
        while (s < e) {
            int m = s + (e - s) / 2;
            if (m<e && nums[m] > nums[m + 1]) {
                pivot = m + 1;
                break;
            } else if (m>s && nums[m] < nums[m - 1]) {
                pivot = m;
                break;
            } else if( nums[s] == nums[m] && nums[m] == nums[e] ){
                if( nums[s] > nums[s+1] ){
                    pivot = s+1 ;
                    break ;
                }
                s++ ;
                if( nums[e] < nums[e-1] ){
                    pivot = e ;
                    break ;
                }
                e-- ;

            } else if( nums[s] < nums[m] || ( nums[s] == nums[m] && nums[m]>nums[e] ) ){
                s = m+1  ;
            } else{
                e = m-1 ;
            }
        }
        return nums[pivot];
    }
}
