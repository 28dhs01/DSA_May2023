package com.dhruv.graphs_ds.algos.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NumberOfProvinces {
    public static void main(String[] args) {
        int[][] isConnected = {{1,1,1,0,0},
                {1,1,1,0,0},
                {0,1,1,0,0},
                {0,0,0,1,1,0},
                {0,0,0,1,1,0},
                {0,0,0,0,0,1}
                              };
        int ans = findCircleNum(isConnected);
        System.out.println(ans);

    }
    public static int findCircleNum(int[][] isConnected) {
        List<Edge>[] graph = new ArrayList[isConnected.length] ;
        int n = isConnected.length ;
        for( int i = 0 ; i<n ; i++ ){
            graph[i] = new ArrayList<>();
        }
        for( int i = 0 ; i< isConnected.length ; i++  ){
            List<Edge> edgeList = graph[i] ;
            for(int j = 0 ; j< isConnected[0].length ; j++ ){
                if( i != j && isConnected[i][j] == 1 ){
                    edgeList.add(new Edge(i,j));
                }
            }
        }
        for( List<Edge> edgeList : graph ){
            for( Edge e: edgeList ){
                System.out.print(e.src +" - "+ e.nbr +" ,");
            }
            System.out.println();
        }
        boolean [] visited = new boolean[n] ;
        int components = 0 ;
        for ( int i = 0 ; i< visited.length ; i++ ){
            if( visited[i] == false ){
                visited[i] = true ;
                findComponents(graph,i,visited);
                components++ ;
            }
        }
        return components ;
    }
    static void findComponents(List<Edge>[] graph, int src, boolean[] visited){
        for( Edge e: graph[src] ){
            if( visited[e.nbr] == false ){
                visited[e.nbr] = true ;
                findComponents(graph,e.nbr,visited) ;
            }
        }
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
