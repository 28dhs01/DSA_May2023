package com.dhruv.recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1,2,3} ;
        List<List<Integer>> ans = permute(nums) ;
        for( List<Integer>list: ans){
            System.out.println(list);
        }
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ansList = new ArrayList<>() ;
        List<Integer> inList = new ArrayList<>() ;
        boolean[] vis = new boolean[nums.length] ;
        helper(nums,ansList,inList,0,vis);
        return ansList ;
    }
    static void helper( int[]nums, List<List<Integer>> ansList, List<Integer> inList , int curIdx, boolean[] vis ){
        if( curIdx == nums.length ){
            List<Integer> copyList = new ArrayList<>(inList) ;
            ansList.add(copyList) ;
            return ;
        }
        for( int i = 0 ; i<nums.length; i++ ){
            if( vis[i] == false ){
                vis[i] = true ;
                inList.add(nums[i]) ;
                helper(nums,ansList,inList,curIdx+1,vis);
                inList.remove(inList.size()-1);
                vis[i] = false ;
            }
        }
    }
}
