package com.dhruv.recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int [] nums = {1,2,3} ;
        List<List<Integer>> ansList = subsets(nums);
        for( List<Integer> lst :ansList ){
            System.out.println(lst);
        }
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ansList = new ArrayList<>() ;
        List<Integer> inList = new ArrayList<>() ;
        helper(nums,ansList,0,inList);
        return ansList;
    }
     static void  helper( int[] nums, List<List<Integer>> ansList, int idx, List<Integer> inList ){
        if( idx == nums.length ){
            ansList.add(inList);
            return ;
        }
        List<Integer> modList = new ArrayList<>() ;
        for( int i = 0 ; i<inList.size() ; i++ ){
            modList.add(inList.get(i));
        }
        modList.add(nums[idx]);
//         System.out.println(modList);
//         System.out.println(inList);
        helper( nums,ansList,idx+1,modList);
        helper( nums,ansList,idx+1,inList);

    }
}
