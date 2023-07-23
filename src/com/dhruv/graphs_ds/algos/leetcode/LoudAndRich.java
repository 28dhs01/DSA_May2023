package com.dhruv.graphs_ds.algos.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoudAndRich {
    public static void main(String[] args) {
        int[][] richer = {
                {1,0},
                {2,1},
                {3,1},
                {3,7},
                {4,3},
                {5,3},
                {6,3}
        };
        int [] quiet = {3,2,5,4,6,1,7,0} ;
        int[] res = loudAndRich(richer,quiet) ;
        System.out.println(Arrays.toString(res));
    }
    public static int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length ;
        ArrayList<Integer>[] graph = new ArrayList[n] ;
        for( int i = 0 ; i<n ; i++ ){
            graph[i] = new ArrayList<>() ;
        }
        makeGraph(graph,richer) ;
        for( int i = 0 ; i<n ; i++ ){
            ArrayList<Integer> list = graph[i] ;
//            System.out.println(list) ;
        }
        int[] memo = new int[n] ;
        Arrays.fill(memo,-1);
        int[] res = new int[n] ;
        for ( int i = 0 ; i<n ; i++ ){
            res [i] = dfs2(graph,quiet,i,i,memo) ;
        }
//        List<List<Pair>> outerList = new ArrayList<>();
//        for( int i = 0 ; i<n ; i++ ){
//            List<Pair> list = new ArrayList<>();
//            dfs(graph,i,quiet,quiet[i],i,list) ;
//            for( Pair p: list ){
//                System.out.print(p.person+" "+p.qutLvl+" , ");
//            }
//            System.out.println();
//            outerList.add(list) ;
//        }
//        int i = 0 ;
//        for( List<Pair> innerList : outerList ){
//            res[i] = getMin(innerList) ;
//            i++ ;
//        }
        return res ;
    }
//    static int getMin(List<Pair> list){
//        int mnLvl = list.get(0).qutLvl ;
//        int mnPsn = list.get(0).person ;
//        for( int i = 1 ; i<list.size() ; i++ ){
//            if( list.get(i).qutLvl < mnLvl ){
//                mnLvl = list.get(i).qutLvl ;
//                mnPsn = list.get(i).person ;
//            }
//        }
//        return mnPsn ;
//    }
//    static void dfs(ArrayList<Integer>[] graph ,int cur , int[]quiet, int qutLvl, int mnNode,List<Pair> list){
//        list.add(new Pair(cur,quiet[cur])) ;
//        if( graph[cur].size() == 0 ){
//            return ;
//        }
//        for( int nbr: graph[cur] ){
//            dfs(graph,nbr,quiet,quiet[nbr],nbr,list) ;
//        }
//    }
//    static class Pair{
//        int person ;
//        int qutLvl ;
//        Pair(int person , int qutLvl ){
//            this.person = person ;
//            this.qutLvl = qutLvl ;
//        }
//    }
    static void makeGraph(ArrayList<Integer>[] graph , int[][] richer){
        for( int [] ar: richer ){
            int rich = ar[0] ;
            int poor = ar[1] ;
            ArrayList<Integer> list = graph[poor] ;
            list.add(rich) ;
        }
    }
    static int dfs2(ArrayList<Integer>[] graph ,int[]quiet ,int cur,  int mnQuietPerson ,int[] memo ){
        if( graph[cur].size() == 0 ){
            return mnQuietPerson ;
        }
        if( memo[cur] != -1 ){
            return memo[cur] ;
        }
        for( int nbr: graph[cur] ){
            if( quiet[nbr] < quiet[mnQuietPerson]){
                mnQuietPerson = nbr ;
            }
            int prvCall = dfs2(graph,quiet,nbr,mnQuietPerson,memo) ;
            if( quiet[prvCall] < quiet[mnQuietPerson] ){
                mnQuietPerson = prvCall ;
            }
        }
        memo[cur] = mnQuietPerson ;
        return mnQuietPerson ;
    }
}
