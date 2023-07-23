package com.dhruv.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8 ;
        List<List<Integer>> ansList = combinationSum2(candidates,target);
        for( List<Integer> list : ansList ){
            System.out.println(list);
        }
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        System.out.println(candidates.length);
        List<List<Integer>> ansList = new ArrayList<>() ;
        List<Integer> inList = new ArrayList<>() ;
        Arrays.sort(candidates);
        solve( candidates, target , ansList, inList, 0,0) ;
        return ansList ;
    }
    static void solve (int[]candidates, int target , List<List<Integer>>ansList, List<Integer> inList, int curIdx,int sum ){
        if( sum == target ){
            List<Integer> dmyList = new ArrayList<>(inList);
            if( !ansList.contains(dmyList) ){
                ansList.add(dmyList) ;
            }
        }
        if( curIdx == candidates.length ){
            return ;
        }
        int val = candidates[curIdx];
        inList.add(val);
        sum = sum+val ;
        curIdx = curIdx+1 ;
        solve( candidates, target, ansList,inList ,curIdx,sum);
        inList.remove(inList.size()-1) ;
        sum = sum-val ;
        solve( candidates, target, ansList,inList ,curIdx,sum);
    }
}
