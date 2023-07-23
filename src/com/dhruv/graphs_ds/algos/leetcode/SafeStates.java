package com.dhruv.graphs_ds.algos.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SafeStates {
    public static void main(String[] args) {
        int[][] graph = { {1,2},{2,3},{5},{0},{5},{},{} } ;
        makeGraph(graph);

    }
    static void makeGraph(int[][] arr){
        List<Edge>[] graph = new ArrayList[arr.length];
        for( int i = 0 ; i<graph.length ; i++ ){
            graph[i] = new ArrayList<>();
        }
        int src = 0 ;
        for( int [] ar: arr ){
            List<Edge> list = graph[src] ;
            for( int e: ar ){
                list.add(new Edge(src,e));
            }
            src++ ;
        }
        int curSrc = 0 ;
        for( List<Edge> list: graph ){
            System.out.print(curSrc +"->");
            for( Edge ed: list ){
                System.out.print(ed.nbr+",");
            }
            System.out.println();
            curSrc++ ;
        }
        curSrc = 0 ;
        List<Integer> terminalNodes = new ArrayList<>();
        for(List<Edge> list: graph ){
            if( list.size() == 0 ){
                terminalNodes.add(curSrc);
            }
            curSrc++ ;
        }
        System.out.println(terminalNodes);
        List<Integer> ansList = new ArrayList<>();
        boolean[] visited ;
        for( int curNode = 0 ; curNode< graph.length ; curNode++ ){
            visited = new boolean[graph.length] ;
            applyDfs(graph,curNode,terminalNodes,visited,ansList);
        }
        System.out.println(ansList);
    }
    static boolean applyDfs(List<Edge>[] graph, int curSrc, List<Integer> terminalNodes,boolean [] visited, List<Integer> ansList){

        return false ;
    }
    static class Edge{
        int src ;
        int nbr ;
        Edge(int src, int nbr){
            this.src = src ;
            this.nbr = nbr ;
        }
    }
}
