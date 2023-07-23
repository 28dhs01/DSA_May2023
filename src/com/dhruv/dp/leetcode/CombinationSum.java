package com.dhruv.dp.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] nums = {2,3,6,7} ;
        int target = 7 ;
        List<List<Integer>> ansList = combinationSum(nums,target) ;
        System.out.println(ansList);
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        int m = candidates.length ;
        int n = target+1 ;
        List<List<Integer>>[][] dp = new ArrayList[m][n] ;
        for( int i = 0; i<dp.length ; i++ ){
            for( int j = 0 ; j<dp[0].length ; j++ ){
                if( j == 0 ){
                    List<List<Integer>> ansList = new ArrayList<>( );
                    List<Integer> inList = new ArrayList<>();
                    ansList.add( inList );
                    dp[i][j] = ansList;
                    System.out.println(dp[i][j]);
                }
                else if( i == 0 && j%candidates[0] == 0 ){
                    List<List<Integer>> outerList = dp[i][j-candidates[i]] ;
                    List<Integer> inList = outerList.get(0) ;
                    List<Integer> newInList = new ArrayList<>() ;
                    for( Integer e: inList ){
                        newInList.add(e);
                    }
                    newInList.add(candidates[0]) ;
                    List<List<Integer>> ansList = new ArrayList<>( );
                    ansList.add( newInList );
                    dp[i][j] = ansList;
                    System.out.println(dp[i][j]);

                }
                else if( i== 0 ){
                    dp[i][j] = null ;
                }
                else{
                    if( candidates[i]>j ){
                        dp[i][j] = dp[i-1][j] ;
                    }else{
                        List<List<Integer>> ansList = new ArrayList<>();
                        // non-include
                        List<List<Integer>> uppList = dp[i-1][j] ;
                        if( uppList != null ){
                            ansList.addAll(uppList);
                        }
                        // include
                        System.out.println(dp[i][j-candidates[i]]);
                        List<List<Integer>> lftList = dp[i][j-candidates[i]];
                        if( lftList == null ){
                            dp[i][j] = dp[i-1][j] ;
                        }else{
                            for( List<Integer> inList: lftList ){
                                List<Integer> newInList = new ArrayList<>( );
                                for ( Integer e: inList ){
                                    newInList.add(e) ;
                                }
                                newInList.add(candidates[i]) ;
                                ansList.add(newInList) ;
                            }
                            dp[i][j] = ansList ;
                        }

                        System.out.println(dp[i][j]);

                    }
                }
            }
        }
        return dp[candidates.length-1][target] ;
    }
}
