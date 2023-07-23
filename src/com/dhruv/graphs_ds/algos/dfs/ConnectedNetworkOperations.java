package com.dhruv.graphs_ds.algos.dfs;

import java.util.ArrayList;

public class ConnectedNetworkOperations {
    public static void main(String[] args) {
        int n = 4 ;
        int[][] connections = {{0,1},{0,2},{1,2}} ;
        int ans = makeConnected(n,connections);
        System.out.println(ans);

    }
    public static int makeConnected(int n, int[][] connections) {
        ArrayList<Edge>[] graph = makeGraph(connections,n);
        boolean[] visited = new boolean[n] ;
        ArrayList<ArrayList<Integer>> componentsList = new ArrayList<>();
        for( int v = 0 ; v<visited.length ; v++ ){
            if (visited[v] == false ){
                ArrayList<Integer> innerList = new ArrayList<>();
                connectedComponents(v,graph,visited,innerList);
                componentsList.add(innerList) ;
            }
        }
        int totalEdgesPresent = connections.length ;
        int edgesReq = componentsList.size() ;
        if( totalEdgesPresent - minEdgConsumed >= edgesReq ){
            return edgesReq ;
        }
        return -1 ;

    }
    static int minEdgConsumed = 0 ;
    static void connectedComponents( int src, ArrayList<Edge>[] graph,boolean[]visited,ArrayList<Integer> innerList ){
        visited[src] = true ;
        innerList.add(src) ;
        for( Edge e: graph[src] ){
            minEdgConsumed ++ ;
            if( visited[e.nbr] == false ){
                connectedComponents(e.nbr,graph,visited,innerList);
            }
        }
    }
    static ArrayList<Edge>[] makeGraph(int[][]connections, int n ){
        ArrayList<Edge>[] graph = new ArrayList[n+1];
        for( int i = 0 ; i< graph.length ;i++ ){
            graph[i] = new ArrayList<Edge>();
        }
        for( int row = 0 ; row<connections.length ; row++ ){
            graph[connections[row][0]].add( new Edge(connections[row][0],connections[row][1]));
            graph[connections[row][1]].add(new Edge(connections[row][1],connections[row][0]));

        }
//        for( int i = 0 ; i< graph.length ; i++ ){
//            System.out.print(i+" -> ");
//            for (int j = 0; j < graph[i].size(); j++) {
//                System.out.print(graph[i].get(j).nbr +" ");
//            }
//            System.out.println();
//        }
        return graph ;
    }
    static class Edge{
        int vtx ;
        int nbr ;

        public Edge(int vtx, int nbr) {
            this.vtx = vtx;
            this.nbr = nbr;
        }
    }
}
