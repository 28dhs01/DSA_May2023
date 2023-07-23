package com.dhruv.graphs_ds.algos.dfs;

import java.util.ArrayList;

class Edge{
    int src ;
    int nbr ;
    int wt ;

    public Edge(int src, int nbr, int wt) {
        this.src = src;
        this.nbr = nbr;
        this.wt = wt;
    }
}
public class Algo {
    public static void main(String[] args) {
        int vts = 7 ;
        ArrayList<Edge> [] graph = new ArrayList[vts] ;
        for( int i = 0 ; i< graph.length ; i++ ){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,10));
        graph[0].add(new Edge(0,3,40));

        graph[1].add(new Edge(1,0,10));
        graph[1].add(new Edge(1,2,10));

        graph[2].add(new Edge(2,1,10));
        graph[2].add(new Edge(2,3,10));

        graph[3].add(new Edge(3,0,40));
        graph[3].add(new Edge(3,2,10));
        graph[3].add(new Edge(3,4,2));

        graph[4].add(new Edge(4,3,2));
        graph[4].add(new Edge(4,5,8));
        graph[4].add(new Edge(4,6,10));

        graph[5].add(new Edge(5,4,8));
        graph[5].add(new Edge(5,6,6));

        graph[6].add(new Edge(6,4,10));
        graph[6].add(new Edge(6,5,6));

        boolean []visited = new boolean[vts] ;
        int src = 0 ;
        int des = 6 ;
        dfs(graph,visited,src,des,src+"",0);
    }
    static void dfs( ArrayList<Edge>[] graph, boolean[] visited, int src, int des, String psf, int wsf){
//        base cases
        if( visited[src] == true ){
            return;
        }
        if( src == des ){
            visited[src] = true ;
            System.out.println(src+" via "+psf+" @ "+wsf);
            return;
        }
//        body
        visited[src] = true ;
        System.out.println(src+" via "+psf+" @ "+wsf);
        for( Edge e: graph[src] ){
            dfs(graph,visited,e.nbr,des,psf+e.nbr,wsf+e.wt);
        }
    }
}
