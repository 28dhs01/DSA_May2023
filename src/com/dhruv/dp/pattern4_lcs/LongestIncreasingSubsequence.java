package com.dhruv.dp.pattern4_lcs;

import java.util.ArrayList;
import java.util.List;
// try for memo approach
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
//        int[] nums = {0,1,0,3} ;
        int[] nums = {10,9,2,5,3,7,101,18} ;
        int ans = lengthOfLIS(nums) ;
        System.out.println(ans);
    }
    public static int lengthOfLIS(int[] nums) {
        List<List<Integer>> outerList = new ArrayList<>( );
        List<Integer> inList = new ArrayList<>();
        makeSubsequences(nums,0,inList,outerList);
        for( List<Integer> list: outerList ){
            System.out.println(list);
        }
        int mxl = 0 ;
        for( int i = 0 ; i<outerList.size() ; i++ ){
            int len = outerList.get(i).size() ;
            mxl = Math.max(mxl,len) ;
        }
        return mxl ;
    }
    static void makeSubsequences(int[]nums, int curIdx, List<Integer> inList, List<List<Integer>> outerList){
        if( curIdx == nums.length ){
            List<Integer> dmyList = new ArrayList<>(inList) ;
            outerList.add(dmyList) ;
            return;
        }
//        include
        if( inList.size() == 0 || nums[curIdx] > inList.get(inList.size()-1))  {
            inList.add(nums[curIdx]) ;
            makeSubsequences(nums,curIdx+1,inList,outerList);
            int last = inList.get(inList.size()-1) ;
            inList.remove((Object) last) ;
        }
        //        exclude
        makeSubsequences(nums,curIdx+1,inList,outerList) ;
    }
}
