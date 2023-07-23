package com.dhruv.graphs_ds.algos.dfs;

import java.util.ArrayList;
import java.util.List;

public class FindAllPaths {
    public static void main(String[] args) {
        int[][] graph = {{1,2},{3},{3},{}};
        List<List<Integer>> ansList = allPathsSourceTarget(graph);
        System.out.println(ansList);

    }
//    static class Solution {
        public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            int n = graph.length ;
            ArrayList<Edge>[] myGraph = makeGraph(n, graph);
            List<List<Integer>> ansList = new ArrayList<>();
            ArrayList<Integer> innerList = new ArrayList<>();
            innerList.add(0);
            int src = 0 ;
            int des = n -1 ;
            boolean[]visited = new boolean[n] ;
            findAllPaths( myGraph,src,des,visited,ansList,innerList) ;
            return ansList ;
        }
        static void findAllPaths(ArrayList<Edge>[] myGraph,int src, int des,boolean[]visited, List<List<Integer>>ansList, ArrayList<Integer>innerList){
//         base case
            if( src == des ){
                visited[src] = true ;
                ansList.add(new ArrayList<>(innerList));
                System.out.println(ansList);
                visited[src] = false ;
                return ;
            }
//         body
            visited[src] = true ;
            for( Edge e: myGraph[src] ){
                if( visited[e.nbr] == false ){
                    innerList.add(e.nbr);
                    findAllPaths(myGraph,e.nbr,des,visited,ansList,innerList);
                    innerList.remove(innerList.size()-1);
                }
            }
            visited[src] = false ;
        }
        static ArrayList<Edge>[] makeGraph(int n, int[][] edges){
            ArrayList<Edge>[] graph = new ArrayList[n];
            for( int i = 0; i < graph.length ;i++ ){
                graph[i] = new ArrayList<Edge>();
            }
            for( int i = 0 ; i<edges.length ; i++ ){
                for( int j = 0 ; j<edges[i].length ; j++ ){
                    graph[i].add( new Edge(i,edges[i][j]) );
                }
            }
            return graph ;
        }
        static class Edge{
            int vtx ;
            int nbr ;
            Edge(int vtx, int nbr ){
                this.vtx = vtx ;
                this.nbr = nbr ;
            }
        }
//    }
}
