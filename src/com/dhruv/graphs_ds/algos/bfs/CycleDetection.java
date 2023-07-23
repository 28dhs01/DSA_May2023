package com.dhruv.graphs_ds.algos.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class CycleDetection {
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


        boolean[] visited = new boolean[vts];
        for( int i = 0 ; i<visited.length ; i++ ){
            if ( visited[i] == false ){
                boolean ansForVtx = isCyclic(i,graph,visited);
                if( ansForVtx == true ){
                    System.out.println("cycle detected");
                    break;
                }
            }
        }

    }
    static boolean isCyclic(int srcVtx, ArrayList<Edge> [] graph, boolean[]visited ){
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(srcVtx));
//        r m* w a*
        while (!q.isEmpty()){
            Pair rmv = q.remove();
//            m*
            if( visited[rmv.vtx] == true ){
                return true;
            }
            visited[rmv.vtx] = true ;
//            a*
            for (Edge e: graph[srcVtx]) {
                if( visited[e.nbr] == false ){
                    q.add(new Pair(e.nbr));
                }
            }
        }
        return false ;
    }
    static class Pair{
        int vtx ;

        public Pair(int vtx) {
            this.vtx = vtx;
        }
    }


}
