package com.dhruv.hashmap_ds.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int [] nums = {-1,0,1,2,-1,-4};
        Arrays.sort(nums);
        HashMap<Integer,Integer> map = new HashMap<>();
        List<List<Integer>> outerList = new ArrayList<>();
        for( int i =0 ;i< nums.length ; i ++ ){
           List< int[] >twoSumList = twoSum(i+1,nums,-nums[i]);
//            System.out.println(twoSumList);
           if(twoSumList != new ArrayList<int[]>() ){
               List<Integer> innerList = new ArrayList<>();
               for( int k = 0 ; k<twoSumList.size() ; k++  ) {
                   innerList.add(nums[i]);
                   innerList.add(twoSumList.get(k)[0]);
                   innerList.add(twoSumList.get(k)[1]);
                   if (!outerList.contains(innerList)) {
                       outerList.add(innerList);
                   }
                   innerList = new ArrayList<>();
               }
           }
        }
        System.out.println(outerList);
    }
    public static List<int[]> twoSum(int s, int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>() ;
        List<int[]> list = new ArrayList<>();
        for( int i = s ; i<nums.length ;i++){
            if( map.containsKey(target-nums[i]) ){
                int [] ans= new int[2];
                ans[0] = nums[i];
                ans[1] = target-nums[i];
                list.add(ans);
            }
            map.put(nums[i],i);
        }
        return list;
    }
}
