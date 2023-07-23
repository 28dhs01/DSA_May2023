package com.dhruv.graphs_ds.algos.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class SpreadInfection {
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


        boolean[] visited = new boolean[vts] ;
        int timeTaken = timeTaken(graph,visited,0);
        for( int i = 0 ; i<visited.length ; i++ ){
            if( visited[i] == false ){
                System.out.println(-1);
                return;
            }
        }
        System.out.println(timeTaken);



    }
    static int timeTaken(ArrayList<Edge>[] graph, boolean[] visited, int srcVtx ){
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(srcVtx,1));
        int timePassed = 1 ;
        while (!q.isEmpty()){
//            r m* w a*

            Pair rmv = q.remove() ;
            if( visited[rmv.vtx] == true ){
//                do some work
                continue;
            }
            visited[rmv.vtx] = true ;
            timePassed = rmv.time;
            for( Edge e: graph[rmv.vtx] ){
                if( visited[e.nbr] == false ){
                    q.add(new Pair(e.nbr, rmv.time+1));
                }
            }

        }
        return timePassed ;
    }
    static class Pair{
        int vtx ;
        int time ;

        public Pair(int vtx, int time) {
            this.vtx = vtx;
            this.time = time;
        }
    }

}
