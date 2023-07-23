package com.dhruv.graphs_ds.algos.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class BipartiteGraph {
    public static void main(String[] args) {
        int vts = 7 ;
        ArrayList<Edge>[] graph = new ArrayList[vts];
        for( int i = 0 ; i< graph.length; i++ ){
            graph[i] = new ArrayList<Edge>();
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
        graph[4].add(new Edge(4,5,2));
        graph[4].add(new Edge(4,6,8));

        graph[5].add(new Edge(5,4,2));
        graph[5].add(new Edge(5,6,6));

        graph[6].add(new Edge(6,4,8));
        graph[6].add(new Edge(6,5,6));


        int[] visited = new int[vts];
        Arrays.fill(visited,-1);
        for( int vtx = 0 ; vtx < vts ; vtx++ ){
            if ( visited[vtx] == -1 ){
                boolean curAns = isBipartite(graph,vtx, visited);
                if( curAns == false ){
                    System.out.println("not a bipartite");
                    return;
                }
            }
        }
        System.out.println("bipartite");

    }
    static boolean isBipartite(ArrayList<Edge> [] graph, int srcVtx , int[] visited ){
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(srcVtx,0));
//        r m* w a*
        while( !q.isEmpty() ){
            Pair rmv = q.remove() ;
            if( visited[rmv.vtx] != -1 ){
//                cycle is found
                if( rmv.lvl == visited[rmv.vtx] ){
//                    even cycle
                    continue;
                }else {
                    return false ;
                }

            }
//            mark*
            visited[rmv.vtx] = rmv.lvl;
//            add*
            for( Edge e: graph[srcVtx] ){
                if( visited[e.nbr] == -1 ){
                    q.add(new Pair(e.nbr, rmv.lvl+1));
                }
            }
        }
        return true ;
    }
    static class Pair{
        int vtx ;
        int lvl ;

        public Pair(int vtx,int lvl ) {
            this.vtx = vtx ;
            this.lvl = lvl ;
        }
    }

}
