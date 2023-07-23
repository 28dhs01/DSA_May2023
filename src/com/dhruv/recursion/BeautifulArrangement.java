package com.dhruv.recursion;

import java.util.ArrayList;
import java.util.List;

public class BeautifulArrangement {
    public static void main(String[] args) {
        int n = 4 ;
        countArrangement(n) ;
    }
    public static int countArrangement(int n) {
        int[] ar = new int[n] ;
        for( int i = 0 ; i<ar.length ; i++ ){
            ar[i] = i+1 ;
        }
        List<List<Integer>> outList = new ArrayList<>() ;
        List<Integer> inList = new ArrayList<>() ;
        boolean[] visited = new boolean[n] ;
        makePermutations(ar,outList,inList,0,visited) ;
        System.out.println(outList) ;
        return outList.size() ;
    }
    static void makePermutations(int[]ar, List<List<Integer>> outList, List<Integer>inList, int curIdx,boolean[] visited ){
//        System.out.println(inList);
        if( curIdx == ar.length ){
            List<Integer> dmyList = new ArrayList<>(inList) ;
            outList.add(dmyList) ;
            return ;
        }
        for( int i = 0 ; i<ar.length ; i++ ){
            if(!visited[i]){
                //                 here some changes
                visited[i] = true ;
                inList.add(ar[i]) ;
                if( inList.get(inList.size()-1)%(inList.size()) == 0 ||(inList.size())%inList.get(inList.size()-1) == 0 ){
                    makePermutations(ar,outList,inList,curIdx+1,visited) ;
                }
                visited[i] = false ;
                int rmvIdx = inList.size()-1 ;
                inList.remove(rmvIdx) ;
            }
        }
    }
}
