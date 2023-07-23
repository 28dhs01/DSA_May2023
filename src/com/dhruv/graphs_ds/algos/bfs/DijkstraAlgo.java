package com.dhruv.graphs_ds.algos.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DijkstraAlgo {
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
        graph[4].add(new Edge(4,6,6));

        graph[5].add(new Edge(5,4,2));
        graph[5].add(new Edge(5,6,8));

        graph[6].add(new Edge(6,4,6));
        graph[6].add(new Edge(6,5,8));

        boolean []visited = new boolean[vts];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,0+"",0));
        while( !pq.isEmpty() ){
//            r m* w a*
            Pair rmv = pq.remove();
            if( visited[rmv.vtx] == true ){
//                do some work
                continue;
            }
            visited[rmv.vtx] = true ;

//            w
            System.out.println(rmv.vtx+" via "+rmv.psf +" @ "+rmv.wsf);
//            a*
            for( Edge e: graph[rmv.vtx] ){
                if( visited[e.nbr] == false ){
                    pq.add(new Pair(e.nbr,rmv.psf+e.nbr, rmv.wsf+e.wt));
                }
            }
        }
    }
    static class Pair implements Comparable<Pair> {
        int vtx ;
        String psf ;
        int wsf ;

        public Pair(int vtx, String psf, int wsf) {
            this.vtx = vtx;
            this.psf = psf;
            this.wsf = wsf;
        }

        @Override
        public int compareTo(Pair o) {
            return this.wsf-o.wsf;
        }
    }

}
