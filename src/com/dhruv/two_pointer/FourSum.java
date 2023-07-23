package com.dhruv.two_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        int[]nums = {1,0,-1,0,-2,2};
        int target = 0;
        List<List<Integer>> ans = fourSum(nums,target) ;
        for( List<Integer> list: ans ){
            System.out.println(list);
        }
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums) ;
        List<List<Integer>> ansList = new ArrayList<>() ;
        for( int i = 0 ; i<nums.length ; i++ ){
            for( int j = i+1 ; j<nums.length ; j++ ){
                int k = j+1 ;
                int l = nums.length-1 ;
                while( k<l ){
                    long sum = (long)nums[i]+(long)nums[j]+(long)nums[k]+(long)nums[l] ;
                    if( sum == (long)target ){
                        List<Integer> inList = new ArrayList<>() ;
                        inList.add(nums[i]) ;
                        inList.add(nums[j]) ;
                        inList.add(nums[k]) ;
                        inList.add(nums[l]) ;
                        if( !ansList.contains(inList) ){
                            ansList.add(inList) ;
                        }
                    }
                    if ( sum > target ){
                        l-- ;
                    }else{
                        k++ ;
                    }
                }
            }
        }
        return ansList ;
    }
}
